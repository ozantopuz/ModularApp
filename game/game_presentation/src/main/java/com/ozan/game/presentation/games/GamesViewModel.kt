package com.ozan.game.presentation.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozan.core.domain.UseCase
import com.ozan.core.error.ErrorFactory
import com.ozan.core.model.DataHolder
import com.ozan.core.presentation.base.BaseViewModel
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.GamesUseCase.Params
import com.ozan.game.domain.GamesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val useCaseFlow: UseCase.FlowRetrieveUseCase<Params, GamesResponse>,
    private val mapper: GameViewEntityMapper,
    private val errorFactory: ErrorFactory
) : BaseViewModel() {

    private val _gamesLiveData = MediatorLiveData<DataHolder<List<DisplayItem>>>()
    private val _pageLiveData = MutableLiveData<Int>()
    private val games = ArrayList<DisplayItem>()
    private val page = Page()
    private var count = 0

    val gamesLiveData: LiveData<DataHolder<List<DisplayItem>>>
        get() = _gamesLiveData

    init {
        _gamesLiveData.value = DataHolder.Success(games)
        _gamesLiveData.addSource(_pageLiveData) {
            fetchGames(it)
        }
    }

    fun getGamesByPagination() {
        _pageLiveData.value?.let {
            val nextPage = page.currentPage + 1
            if (nextPage * page.pageSize > count) {
                return
            }
            _pageLiveData.value = nextPage
        } ?: run {
            _pageLiveData.value = page.currentPage
        }
    }

    private fun fetchGames(page: Int) {
        _gamesLiveData.value = DataHolder.Loading()
        val params = Params(page)

        viewModelScope.launch {
            useCaseFlow.execute(params).collect { dataHolder ->
                when(dataHolder) {
                    is DataHolder.Fail -> _gamesLiveData.postValue(DataHolder.Fail(dataHolder.e))
                    is DataHolder.Success -> {
                        this@GamesViewModel.page.currentPage++
                        count = dataHolder.data.count!!

                        val displayItems = dataHolder.data.results?.map { mapper.apply(it) } ?: arrayListOf()
                        _gamesLiveData.postValue(DataHolder.Success(displayItems))
                        games.addAll(displayItems)
                    }
                    else -> return@collect
                }
            }
        }
    }

    data class Page(var currentPage: Int = 1, var pageSize: Int = 20)
}