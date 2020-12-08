package com.wyllyam.common.di

import com.wyllyam.common.dispatcher.DefaultDispatcherProvider
import com.wyllyam.common.dispatcher.DispatcherProvider
import org.koin.dsl.module

val commonModule = module {
    single<DispatcherProvider>{ DefaultDispatcherProvider() }
}