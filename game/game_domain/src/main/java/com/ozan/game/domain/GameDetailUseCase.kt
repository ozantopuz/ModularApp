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

class GameDetailUseCase @Inject constructor(
    private val gameRepository: GameRepository
) : UseCase.FlowRetrieveUseCase<GameDetailUseCase.Params, GameDetail> {

    override suspend fun execute(params: Params): Flow<DataHolder<GameDetail>> {
        return flow {
            val response = gameRepository.fetchGameDetail(params.id)
            emit(response)
        }.catch { throwable ->
            DataHolder.Fail(Error.ApiError(message = throwable.localizedMessage))
        }.flowOn(Dispatchers.IO)
    }

    class Params(val id: Int) : UseCase.Params()
}