package com.ozan.core.data.source

import com.ozan.core.model.DataHolder

interface DataSource {

    interface RetrieveRemoteDataSource<Req, Res : Any> : DataSource {
        suspend fun getResult(request: Req): DataHolder<Res>
    }

    interface Local<K, V> : DataSource {

        suspend fun get(key: K?): V

        suspend fun put(key: K?, data: V): Boolean

        suspend fun remove(value: V): Boolean

        suspend fun clear()
    }

    interface Cache<KEY, VALUE> : DataSource {
        suspend fun get(key: KEY): VALUE?

        suspend fun put(key: KEY, value: VALUE): Boolean

        suspend fun drop()
    }
}
