package com.ozan.game.presentation.gamedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.ozan.core.domain.UseCase
import com.ozan.core.model.DataHolder
import com.ozan.core.presentation.base.BaseViewModel
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.GameDetail
import com.ozan.game.domain.GameDetailUseCase.Params
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val useCase: UseCase.FlowRetrieveUseCase<Params, GameDetail>,
    private val mapper: GameDetailViewEntityMapper
) : BaseViewModel() {

    private val _gameDetailLiveData = MediatorLiveData<DataHolder<DisplayItem>>()

    val gameDetailLiveData: LiveData<DataHolder<DisplayItem>>
        get() = _gameDetailLiveData

    fun fetchGameDetail(id: Int) {
        _gameDetailLiveData.value = DataHolder.Loading()
        val params = Params(id)

        viewModelScope.launch {
            useCase.execute(params).collect { dataHolder ->
                when (dataHolder) {
                    is DataHolder.Fail ->
                        _gameDetailLiveData.postValue(DataHolder.Fail(dataHolder.e))
                    is DataHolder.Success ->
                        _gameDetailLiveData.postValue(DataHolder.Success(mapper.apply(dataHolder.data)))
                    else -> return@collect
                }
            }
        }
    }
}