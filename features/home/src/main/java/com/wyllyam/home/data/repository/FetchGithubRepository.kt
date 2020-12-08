package com.wyllyam.home.data.repository

import com.wyllyam.home.domain.model.GithubRepositories
import com.wyllyam.network.exception.NetworkException

internal interface FetchGithubRepository {

    @Throws(NetworkException::class)
    suspend fun fetchGithubRepositoryList(page: Int): GithubRepositories
}