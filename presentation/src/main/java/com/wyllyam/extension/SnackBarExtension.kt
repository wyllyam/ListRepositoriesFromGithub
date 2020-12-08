package com.wyllyam.extension

//import android.annotation.SuppressLint
//import android.view.View
//import com.google.android.material.snackbar.Snackbar
//
//@SuppressLint("WrongConstant")
//fun View.snackbar(
//    message: String,
//    length: Int = Snackbar.LENGTH_SHORT,
//    f: (Snackbar.() -> Unit)? = null
//) {
//    Snackbar.make(this, message, length).apply {
//        f?.invoke(this)
//        show()
//    }
//}
//
//fun Snackbar.action(
//    text: String,
//    actionTextColor: Int? = null,
//    onClickAction: (View) -> Unit
//) {
//    setAction(text, onClickAction)
//    actionTextColor?.let { setActionTextColor(actionTextColor) }
//}