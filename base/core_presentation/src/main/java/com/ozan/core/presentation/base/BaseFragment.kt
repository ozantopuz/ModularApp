package com.ozan.core.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.ozan.core.error.Error
import com.ozan.core.presentation.R

abstract class BaseFragment : Fragment(), BaseView {

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(), null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onError(e: Error) {
        val message = when (e) {
            is Error.UnknownError -> getString(R.string.error_message_unknown_error)
            is Error.BusinessError -> e.message
            is Error.ApiError -> e.message
        }
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    open fun initView() {
        // can be overridden
    }
}
