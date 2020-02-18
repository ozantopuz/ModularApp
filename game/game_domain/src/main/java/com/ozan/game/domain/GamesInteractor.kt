package com.ozan.game.domain

import com.ozan.core.domain.Interactor
import com.ozan.core.model.DataHolder
import io.reactivex.Observable
import javax.inject.Inject

class GamesInteractor @Inject constructor(
    private val gameRepository: GameRepository
) : Interactor.ReactiveRetrieveInteractor<GamesInteractor.Params, GamesResponse> {

    override fun execute(params: Params): Observable<DataHolder<GamesResponse>> {
        when {
            params.page.toString().isEmpty() -> throw IllegalArgumentException("Invalid page")
            else -> return gameRepository.fetchGames(params.page).toObservable()
        }
    }

    class Params(val page: Int) : Interactor.Params()
}