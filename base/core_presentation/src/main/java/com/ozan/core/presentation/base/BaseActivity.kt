package com.ozan.core.presentation.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.ozan.core.presentation.navigation.UiNavigation

abstract class BaseActivity : AppCompatActivity() {

    open val uiNavigation = UiNavigation.BACK

    @LayoutRes
    abstract fun getLayoutRes(): Int

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initNavigation(uiNavigation)
    }

    private fun initNavigation(uiNavigation: UiNavigation) {
        when (uiNavigation) {
            UiNavigation.BACK -> supportActionBar?.setDisplayHomeAsUpEnabled(true)
            UiNavigation.ROOT -> supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }
}
