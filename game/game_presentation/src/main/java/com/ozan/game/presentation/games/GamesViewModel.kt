package com.ozan.game.presentation.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.ozan.core.domain.Interactor
import com.ozan.core.error.ErrorFactory
import com.ozan.core.model.DataHolder
import com.ozan.core.presentation.base.BaseViewModel
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.Game
import com.ozan.game.domain.GamesInteractor.Params
import com.ozan.game.domain.GamesResponse
import io.reactivex.Observable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GamesViewModel @Inject constructor(
    private val interactor: Interactor.ReactiveRetrieveInteractor<Params, GamesResponse>,
    private val mapper: Function<Game, DisplayItem>,
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

        val gamesFetchDisposable = interactor.execute(params)
            .observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .subscribe({

                when (it) {
                    is DataHolder.Success -> {
                        this.page.currentPage++
                        count = it.data.count!!


                        Observable.fromIterable(it.data.results)
                            .map { item -> mapper.apply(item) }
                            .toList()
                            .blockingGet()
                            .run {
                                _gamesLiveData.postValue(DataHolder.Success(this))
                                games.addAll(this)
                            }
                    }
                    is DataHolder.Fail -> {
                        _gamesLiveData.postValue(DataHolder.Fail(it.e))
                    }
                }
            }, {
                _gamesLiveData.postValue(
                    DataHolder.Fail(
                        errorFactory.createErrorFromThrowable(
                            it
                        )
                    )
                )
            })

        action(gamesFetchDisposable)
    }

    data class Page(var currentPage: Int = 1, var pageSize: Int = 20)
}