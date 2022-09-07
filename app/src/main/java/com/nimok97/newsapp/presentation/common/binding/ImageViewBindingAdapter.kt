package com.nimok97.newsapp.presentation.common.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.nimok97.newsapp.R

@BindingAdapter("app:setStringUrlImage")
fun ImageView.setStringUrlImage(stringUrl: String) {
    Glide.with(this.context)
        .load(stringUrl)
        .error(R.drawable.ic_launcher_foreground)
        .into(this)
}


