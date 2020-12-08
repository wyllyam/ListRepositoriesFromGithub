package com.wyllyam.home.data.repository

import com.wyllyam.home.data.mapper.toDomain
import com.wyllyam.home.data.remote.api.FetchGithubApi
import com.wyllyam.home.domain.model.GithubRepositories
import com.wyllyam.network.base.Outcome
import com.wyllyam.network.exception.NetworkException
import com.wyllyam.network.extension.parseResponse

internal class FetchGithubDataRepository(private val fetchGithubApi: FetchGithubApi) :
    FetchGithubRepository {

    @Throws(NetworkException::class)
    override suspend fun fetchGithubRepositoryList(page: Int): GithubRepositories {
        val response = fetchGithubApi.fetchGithubRepositoryList(
            filter = FILTER,
            page = page,
            rows = ROWS
        ).parseResponse()

        return when (response) {
            is Outcome.Success -> response.value.toDomain()
            is Outcome.Failure -> throw NetworkException.parse()
        }
    }

    companion object {
        private const val LANGUAGE = "kotlin"
        private const val FILTER = "stars"
        private const val ROWS = 20
    }
}