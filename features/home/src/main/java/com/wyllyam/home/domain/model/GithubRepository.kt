package com.wyllyam.home.domain.model

internal data class GithubRepository(
    var repoName: String,
    var repoStarsCount: Long,
    var repoForksCount: Long,
    var repoOwner: GithubRepositoryOwner
)