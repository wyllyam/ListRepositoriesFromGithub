package com.wyllyam.common_test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.junit.Rule

abstract class BaseLifecycleTest : BaseTest() {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private val lifecycleRegistry = LifecycleRegistry(mockk())
    protected val lifecycleOwner = LifecycleOwner { lifecycleRegistry }

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

    protected fun resumeLifecycle() {
        handleLifecycle(Lifecycle.Event.ON_RESUME)
    }

    protected inline fun <reified T : Any> createMockedObserver(): Observer<T> {
        val observer = mockk<Observer<T>>()
        every { observer.onChanged(any()) } just Runs
        return observer
    }
}