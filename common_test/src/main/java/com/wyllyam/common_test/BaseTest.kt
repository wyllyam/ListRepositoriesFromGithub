package com.wyllyam.common_test

import android.content.Context
import com.wyllyam.common_test.di.commonTestModule
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.test.KoinTest

abstract class BaseTest : KoinTest {

    protected val context = mockk<Context>()
    protected abstract val modules: List<Module>

    private val _modules: List<Module> by lazy {
        mutableListOf<Module>().apply {
            addAll(modules)
            add(commonTestModule)
        }.toList()
    }

    @Before
    open fun setUp() {
        startKoin {
            androidContext(context)
            modules(_modules)
        }
    }

    @After
    open fun tearDown() {
        stopKoin()
    }
}