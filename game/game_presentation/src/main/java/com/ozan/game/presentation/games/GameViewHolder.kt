package com.ozan.game.presentation.games

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozan.core.presentation.extensions.loadImage
import com.ozan.core.presentation.recyclerview.DisplayItem
import com.ozan.core.presentation.recyclerview.ViewHolder
import com.ozan.core.presentation.recyclerview.ViewHolderBinder
import com.ozan.core.presentation.recyclerview.ViewHolderFactory
import com.ozan.game.presentation.R
import kotlinx.android.synthetic.main.layout_item_game.view.*
import javax.inject.Inject

class GameViewHolder private constructor(itemView: View) : ViewHolder<GameViewEntity>(itemView) {

    override fun bind(item: GameViewEntity) {
        itemView.textView.text = item.name
        item.backgroundImage?.let { itemView.imageView.loadImage(it) }
        itemView.setOnClickListener { itemClickListener?.invoke(itemView, item) }
    }

    internal class GameViewHolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            GameViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.layout_item_game,
                    parent,
                    false
                )
            )
    }

    internal class GameViewHolderBinder @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as GameViewHolder).bind(item as GameViewEntity)
        }
    }
}