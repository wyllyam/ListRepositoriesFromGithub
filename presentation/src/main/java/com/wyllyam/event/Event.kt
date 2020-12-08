package com.wyllyam.event

import androidx.lifecycle.MutableLiveData
import java.util.concurrent.atomic.AtomicBoolean

open class Event<out T>(private val content: T) {

    private val _consumed = AtomicBoolean(false)
    val consumed: Boolean
        get() = _consumed.get()

    fun consume(): T? {
        return if (_consumed.compareAndSet(false, true)) {
            content
        } else {
            null
        }
    }

    fun peek(): T = content
}

fun MutableLiveData<Event<Unit>>.call() {
    this.postValue(Event(Unit))
}