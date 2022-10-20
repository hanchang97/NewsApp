package com.nimok97.newsapp.presentation.common

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log

fun dpToPx(context: Context, dp: Int): Float {
    val resources = context.resources
    val metrics = resources.displayMetrics
    return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

fun printLog(log: String) {
    Log.e("AppTest", log)
}