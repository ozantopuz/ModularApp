package com.ozan.core.presentation.recyclerview

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter constructor(
    private val items: MutableList<DisplayItem> = ArrayList(),
    private val itemComparator: DisplayItemComparator,
    private val viewHolderFactoryMap: Map<Int, ViewHolderFactory>,
    private val viewBinderFactoryMap: Map<Int, ViewHolderBinder>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), DiffAdapter {

    var itemClickListener: ((view: View, item: DisplayItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        viewHolderFactoryMap[viewType]?.createViewHolder(parent)!!

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        viewBinderFactoryMap[items[position].type()]?.bind(holder, items[position])
        (holder as ViewHolder<*>).itemClickListener = itemClickListener
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].type()

    override fun update(newItems: List<DisplayItem>) {
        if (items.isEmpty()) {
            updateAllItems(newItems)
        } else {
            updateOnlyChangedItems(newItems)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateAllItems(newItems: List<DisplayItem>) {
        updateItems(newItems)
        notifyDataSetChanged()
    }

    override fun updateOnlyChangedItems(newItems: List<DisplayItem>) {
        updateAllItems(newItems)
        val diffResult = calculateDiffResult(newItems)
        updateItems(newItems)
        updateWithOnlyDiffResult(diffResult)
    }

    override fun updateItems(newItems: List<DisplayItem>) {
        items.clear()
        items.addAll(newItems)
    }

    override fun calculateDiff(newItems: List<DisplayItem>): DiffUtil.DiffResult =
        DiffUtil.calculateDiff(
            DiffUtilImpl(
                items,
                newItems,
                itemComparator
            )
        )

    override fun updateWithOnlyDiffResult(result: DiffUtil.DiffResult) {
        result.dispatchUpdatesTo(this)
    }

    override fun addItems(newItems: List<DisplayItem>) {
        val startRange = items.size
        items.addAll(newItems)
        notifyItemRangeChanged(startRange, newItems.size)
    }

    private fun calculateDiffResult(newItems: List<DisplayItem>): DiffUtil.DiffResult =
        calculateDiff(newItems)
}