package com.wyllyam.common_test.di

import com.wyllyam.common_test.TestDispatcherProvider
import org.koin.dsl.module

val commonTestModule = module {
    single(override = true) { TestDispatcherProvider() }
}