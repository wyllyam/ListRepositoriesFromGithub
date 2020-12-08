package com.wyllyam.common.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class DefaultDispatcherProvider: DispatcherProvider {
    override val io: CoroutineDispatcher = Dispatchers.IO
}