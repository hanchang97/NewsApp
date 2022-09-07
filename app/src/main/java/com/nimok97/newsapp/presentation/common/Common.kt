package com.nimok97.newsapp.presentation.common

import android.content.Context
import android.util.DisplayMetrics

fun dpToPx(context: Context, dp: Int): Float {
    val resources = context.resources
    val metrics = resources.displayMetrics
    return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}