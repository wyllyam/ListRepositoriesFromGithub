package com.wyllyam.home.data.mapper

import com.wyllyam.home.data.remote.model.GithubRepositoryOwnerResponse
import com.wyllyam.home.data.remote.model.GithubRepositoryResponse
import com.wyllyam.home.domain.model.GithubRepository
import com.wyllyam.home.domain.model.GithubRepositoryOwner

internal fun GithubRepositoryOwnerResponse.toDomain(): GithubRepositoryOwner {
    return GithubRepositoryOwner(
        authorImageUrl = authorImageUrl
    )
}

internal fun List<GithubRepositoryOwnerResponse>.toDomain(): List<GithubRepositoryOwner> {
    return map { response -> response.toDomain() }
}

