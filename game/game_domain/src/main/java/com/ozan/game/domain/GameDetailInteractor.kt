package com.ozan.game.domain

import com.ozan.core.domain.Interactor
import com.ozan.core.model.DataHolder
import io.reactivex.Observable
import javax.inject.Inject

class GameDetailInteractor @Inject constructor(
    private val gameRepository: GameRepository
) : Interactor.ReactiveRetrieveInteractor<GameDetailInteractor.Params, GameDetail> {

    override fun execute(params: Params): Observable<DataHolder<GameDetail>> {
        when {
            params.id.toString().isEmpty() -> throw IllegalArgumentException("Invalid id")
            else -> return gameRepository.getGameDetail(
                params.id
            ).toObservable()
        }
    }

    class Params(val id: Int) : Interactor.Params()
}