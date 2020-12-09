package com.wyllyam.network.extension

import com.wyllyam.network.base.Either
import retrofit2.Response
import java.net.HttpURLConnection

fun <R : Any> Response<R>.parseResponse(): Either<R> {
    if (isSuccessful) {
        val body = body()

        if (body != null) {
            return Either.Success(body)
        }
    } else {
        return parseErrorBody(this.code())
    }
    return Either.Failure(HttpURLConnection.HTTP_INTERNAL_ERROR)
}

internal fun parseErrorBody(
    code: Int
): Either.Failure {
    return try {
        Either.Failure(code)
    } catch (e: Exception) {
        Either.Failure(HttpURLConnection.HTTP_INTERNAL_ERROR)
    }
}