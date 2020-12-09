package com.wyllyam.network.base

import java.lang.Exception

sealed class Either<out T> {
    data class Success<out T>(val value: T) : Either<T>()
    data class Failure(val statusCode: Int) : Either<Nothing>()
}