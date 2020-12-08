package com.wyllyam.home.data.mapper

import com.wyllyam.home.data.remote.model.GithubRepositoryResponse
import com.wyllyam.home.domain.model.GithubRepository

internal fun GithubRepositoryResponse.toDomain(): GithubRepository {
    return GithubRepository(
        repoName = repoName,
        repoStarsCount = repoStarsCount,
        repoForksCount = repoForksCount,
        repoOwner = repoOwner.toDomain()
    )
}

internal fun List<GithubRepositoryResponse>.toDomain(): List<GithubRepository> {
    return map { response -> response.toDomain() }
}

