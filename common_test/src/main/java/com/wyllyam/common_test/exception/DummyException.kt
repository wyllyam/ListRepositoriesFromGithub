package com.wyllyam.common_test.exception

class DummyException @JvmOverloads constructor(cause: Throwable? = null) :
    Exception(MESSAGE, cause) {

    companion object {
        const val MESSAGE = "Dummy Exception!!"
    }
}
