package com.wyllyam.extension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
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

fun View.hideKeyboard() {
    try {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager

        inputMethodManager?.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}