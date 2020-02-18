package com.ozan.core.presentation.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

/*
 * Loads image into current target
 */
fun ImageView.loadImage(url: String) {

    Glide.with(this)
        .load(url)
        .into(this)
}