package com.ozan.game.presentation.gamedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ozan.core.domain.Interactor
import com.ozan.core.error.ErrorFactory
import com.ozan.core.model.DataHolder
import com.ozan.core.presentation.base.BaseViewModel
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.game.domain.GameDetail
import com.ozan.game.domain.GameDetailInteractor.Params
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GameDetailViewModel @Inject constructor(
    private val interactor: Interactor.ReactiveRetrieveInteractor<Params, GameDetail>,
    private val mapper: Function<GameDetail, DisplayItem>,
    private val errorFactory: ErrorFactory
) : BaseViewModel() {

    private val _gameDetailLiveData = MediatorLiveData<DataHolder<DisplayItem>>()

    val gameDetailLiveData: LiveData<DataHolder<DisplayItem>>
        get() = _gameDetailLiveData

    fun fetchGameDetail(id: Int) {
        _gameDetailLiveData.value = DataHolder.Loading()
        val params = Params(id)
        val gameDetailFetchDisposable = interactor.execute(params)
            .observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (it) {
                    is DataHolder.Success -> {
                        _gameDetailLiveData.postValue(DataHolder.Success(mapper.apply(it.data)))
                    }
                    is DataHolder.Fail -> { _gameDetailLiveData.postValue(DataHolder.Fail(it.e)) }
                }
            }, {
                _gameDetailLiveData.postValue(
                    DataHolder.Fail(
                        errorFactory.createErrorFromThrowable(
                            it
                        )
                    )
                )
            })
        action(gameDetailFetchDisposable)
    }
}