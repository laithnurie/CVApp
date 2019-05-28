package com.laithlab.cvapp

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(this)
            .load(imageUrl)
            .into(this)
}