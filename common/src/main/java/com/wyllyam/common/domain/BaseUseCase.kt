package com.wyllyam.common.domain

interface BaseUseCase<Params, out T>{
    suspend fun execute(params: Params? = null): T
}