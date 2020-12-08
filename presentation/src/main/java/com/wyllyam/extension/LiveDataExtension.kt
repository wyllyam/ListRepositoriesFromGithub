package com.wyllyam.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <M> MutableLiveData<M>.toLiveData(): LiveData<M> {
    return this
}
