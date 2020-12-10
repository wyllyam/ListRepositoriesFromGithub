package com.wyllyam.common_test.extensions

import org.junit.Assert.fail

suspend inline fun <reified T : Exception> coVerifyException(
    noinline executionBlock: suspend () -> Unit,
    crossinline verificationBlock: suspend (exception: T) -> Unit
) {
    try {
        executionBlock()
        fail("Verification failed.\n\tExpected exception: <${T::class.java.name}>\n\tActual exception: <Nothing>")
    } catch (e: Exception) {
        if (e is T) {
            verificationBlock(e)
        } else {
            fail("Verification failed.\n\tExpected exception: <${T::class.java.name}>\n\tActual exception: <${e::class.java.name}>")
        }
    }
}
