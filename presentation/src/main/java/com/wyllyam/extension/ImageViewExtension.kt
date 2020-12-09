package com.wyllyam.extension

import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation
import com.wyllyam.presenter.R

fun ImageView.loadImage(url: String){
    this.load(uri = url){
        crossfade(true)
        placeholder(R.drawable.ic_user)
        transformations(CircleCropTransformation())
    }
}