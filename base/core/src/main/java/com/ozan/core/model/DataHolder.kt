package com.ozan.core.model

import com.ozan.core.error.Error

sealed class DataHolder<out T : Any> {

    data class Success<out T : Any>(val data: T) : DataHolder<T>()

    data class Fail(val e: Error) : DataHolder<Nothing>()

    class Loading : DataHolder<Nothing>()
}
