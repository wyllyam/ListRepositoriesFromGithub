@file:Suppress("DeferredIsResult")
@file:JvmName("CoroutineScopeUtil")

package com.wyllyam.common.extension

import com.wyllyam.common.dispatcher.DispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext

val CoroutineScope.dispatcherProvider by lazy {
    GlobalContext.get().get<DispatcherProvider>()
}

inline fun CoroutineScope.launchIO(crossinline execution: suspend CoroutineScope.() -> Unit) {
    this.launch(dispatcherProvider.io) { execution() }
}
