package com.wyllyam.network.extension

import com.google.gson.Gson
import com.wyllyam.network.base.BaseErrorResponse
import com.wyllyam.network.base.Outcome
import retrofit2.Response
import java.net.HttpURLConnection

fun <R : Any> Response<R>.parseResponse(errorResponse: Class<out BaseErrorResponse> = BaseErrorResponse::class.java): Outcome<R> {
    if (isSuccessful) {
        val body = body()

        if (body != null) {
            return Outcome.Success(body)
        }
    } else {
        return parseErrorBody(
            this.code(),
            errorBody()?.string() ?: "",
            errorResponse
        )
    }
    return Outcome.Failure(HttpURLConnection.HTTP_INTERNAL_ERROR)
}

internal fun parseErrorBody(
    code: Int,
    errorBody: String,
    errorResponse: Class<out BaseErrorResponse>
): Outcome.Failure {
    return try {
        Outcome.Failure(
            code,
            Gson().fromJson(errorBody, errorResponse)
        )
    } catch (e: Exception) {
        Outcome.Failure(HttpURLConnection.HTTP_INTERNAL_ERROR)
    }
}