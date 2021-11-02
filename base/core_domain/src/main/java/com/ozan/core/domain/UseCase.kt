package com.ozan.core.domain

import com.ozan.core.model.DataHolder
import kotlinx.coroutines.flow.Flow

interface UseCase {

    interface FlowRetrieveUseCase<P : Params, R : Any> : UseCase {
        suspend fun execute(params: P): Flow<DataHolder<R>>
    }

    abstract class Params
}