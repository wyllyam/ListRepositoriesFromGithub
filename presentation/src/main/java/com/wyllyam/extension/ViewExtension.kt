package com.wyllyam.extension

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.annotation.LayoutRes

@JvmOverloads
fun ViewGroup.inflate(@LayoutRes layoutResId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context)
        .inflate(layoutResId, this, attachToRoot)

fun View.visible(){
    hide(VISIBLE)
}

fun View.gone(){
    hide(GONE)
}

private fun View.hide(hidingStrategy: Int){
    visibility = hidingStrategy
}