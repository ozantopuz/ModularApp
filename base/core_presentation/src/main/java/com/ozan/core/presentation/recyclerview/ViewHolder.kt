package com.ozan.core.presentation.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ozan.core.presentation.entity.ViewEntity

abstract class ViewHolder<T : ViewEntity>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
    var itemClickListener: ((view: View, item: DisplayItem) -> Unit)? = null
    var itemLongClickListener: ((view: View, item: DisplayItem) -> Unit)? = null
}