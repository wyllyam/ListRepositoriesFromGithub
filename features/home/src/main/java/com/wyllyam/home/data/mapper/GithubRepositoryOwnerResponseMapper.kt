package com.wyllyam.home.data.mapper

import com.wyllyam.home.data.remote.model.GithubRepositoryOwnerResponse
import com.wyllyam.home.domain.model.GithubRepositoryOwner

internal fun GithubRepositoryOwnerResponse.toDomain(): GithubRepositoryOwner {
    return GithubRepositoryOwner(
        authorName = authorName,
        authorImageUrl = authorImageUrl
    )
}

internal fun List<GithubRepositoryOwnerResponse>.toDomain(): List<GithubRepositoryOwner> {
    return map { response -> response.toDomain() }
}

