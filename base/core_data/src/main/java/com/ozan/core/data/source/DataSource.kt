package com.ozan.core.data.source

import com.ozan.core.model.DataHolder
import io.reactivex.Flowable
import io.reactivex.Single

interface DataSource {

    interface RetrieveRemoteDataSource<Req, Res : Any> : DataSource {
        fun getResult(request: Req): Single<DataHolder<Res>>
    }

    interface FlowableLocal<K, V> : DataSource {

        fun get(key: K?): Flowable<V>

        fun put(key: K?, data: V): Boolean

        fun remove(value: V): Boolean

        fun clear()
    }

    interface Cache<KEY, VALUE> : DataSource {
        fun get(key: KEY): VALUE?

        fun put(key: KEY, value: VALUE): Boolean

        fun drop()
    }
}
