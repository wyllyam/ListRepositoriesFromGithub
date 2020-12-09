package com.wyllyam.home.data.repository

import com.wyllyam.home.data.mapper.toDomain
import com.wyllyam.home.data.remote.api.Api
import com.wyllyam.home.domain.model.GithubRepositories
import com.wyllyam.network.base.Either
import com.wyllyam.network.exception.NetworkException
import com.wyllyam.network.extension.parseResponse

internal class FetchGithubDataRepository(private val api: Api) : FetchGithubRepository {

    @Throws(NetworkException::class)
    override suspend fun fetchGithubRepositories(page: Int): GithubRepositories {
        val response = api.fetchGithubRepositories(page = page).parseResponse()

        return when (response) {
            is Either.Success -> response.value.toDomain()
            is Either.Failure -> throw NetworkException.parse()
        }
    }
}