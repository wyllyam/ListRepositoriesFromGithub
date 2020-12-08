package com.wyllyam.home.presenter.model

internal data class GithubRepositoryVO(
    var repoName: String,
    var repoStarsCount: Long,
    var repoForksCount: Long,
    val repoOwner: GithubRepositoryOwnerVO
)