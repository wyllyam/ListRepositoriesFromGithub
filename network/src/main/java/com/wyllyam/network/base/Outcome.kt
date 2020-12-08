package com.wyllyam.network.base

sealed class Outcome<out T> {
    data class Success<out T>(val value: T) : Outcome<T>()
    data class Failure(
        val statusCode: Int,
        val baseErrorResponse: BaseErrorResponse? = null
    ) : Outcome<Nothing>()
}