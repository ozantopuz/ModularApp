package com.ozan.game.domain

import com.ozan.core.domain.UseCase
import com.ozan.core.error.Error
import com.ozan.core.model.DataHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GamesUseCase @Inject constructor(
    private val gameRepository: GameRepository
) : UseCase.FlowRetrieveUseCase<GamesUseCase.Params, GamesResponse> {

    override suspend fun execute(params: Params): Flow<DataHolder<GamesResponse>> {
        return flow {
            val response = gameRepository.fetchGames(params.page)
            emit(response)
        }.catch { throwable ->
            val error = DataHolder.Fail(Error.ApiError(message = throwable.localizedMessage))
            emit(error)
        }.flowOn(Dispatchers.IO)
    }

    class Params(val page: Int) : UseCase.Params()
}