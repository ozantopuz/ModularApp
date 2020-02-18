package com.ozan.core.presentation.base

import com.ozan.core.error.Error

interface BaseView {
    fun onError(e: Error)
}
