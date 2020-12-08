package com.wyllyam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wyllyam.common.extension.launchIO
import kotlinx.coroutines.CoroutineScope

abstract class BaseViewModel: ViewModel() {

    protected inline fun launchIO(crossinline execution: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launchIO(execution)
    }
}