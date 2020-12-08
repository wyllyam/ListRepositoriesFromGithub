package com.wyllyam.common_test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import io.mockk.mockk
import org.junit.Rule

abstract class BaseLifecycleTest : BaseTest() {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private val lifecycleRegistry = LifecycleRegistry(mockk())

    override fun setUp() {
        super.setUp()
        handleLifecycle(Lifecycle.Event.ON_CREATE)
    }

    override fun tearDown() {
        handleLifecycle(Lifecycle.Event.ON_DESTROY)
        super.tearDown()
    }

    protected fun handleLifecycle(event: Lifecycle.Event) {
        lifecycleRegistry.handleLifecycleEvent(event)
    }
}