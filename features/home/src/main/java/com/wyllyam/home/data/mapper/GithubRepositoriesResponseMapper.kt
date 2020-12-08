package com.wyllyam.home.data.mapper

import com.wyllyam.home.data.remote.model.GithubRepositoriesResponse
import com.wyllyam.home.domain.model.GithubRepositories

internal fun GithubRepositoriesResponse.toDomain(): GithubRepositories {
    return GithubRepositories(
        items = items.toDomain()
    )
}

internal fun List<GithubRepositoriesResponse>.toDomain(): List<GithubRepositories> {
    return map { response -> response.toDomain() }
}
