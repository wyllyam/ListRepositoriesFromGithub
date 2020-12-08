package com.wyllyam.network.exception

sealed class NetworkException(
    message: String? = null,
    throwable: Throwable? = null
) : Exception(message, throwable) {

    class InternalError(message: String? = null, throwable: Throwable? = null) :
        NetworkException(message, throwable)

    companion object {
        fun parse(message: String? = null, throwable: Throwable? = null) =
            InternalError(
                message,
                throwable
            )
    }
}