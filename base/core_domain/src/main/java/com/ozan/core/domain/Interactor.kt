package com.ozan.core.domain

import com.ozan.core.model.DataHolder
import io.reactivex.Flowable
import io.reactivex.Observable

interface Interactor {

    interface ReactiveRetrieveInteractor<P : Params, R : Any> : Interactor {
        fun execute(params: P): Observable<DataHolder<R>>
    }

    interface FlowableRetrieveInteractor<P : Params, R : Any> : Interactor {
        fun execute(params: P): Flowable<R>
    }

    abstract class Params
}