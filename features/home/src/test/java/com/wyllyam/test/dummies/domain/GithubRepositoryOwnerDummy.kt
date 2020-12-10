package com.wyllyam.test.dummies.domain

import com.wyllyam.home.domain.model.GithubRepositoryOwner

internal object GithubRepositoryOwnerDummy {

    private const val DUMMY_REPO_OWNER_NAME = "dummyRepoOwnerName"
    private const val DUMMY_REPO_OWNER_IMAGE = "https://avatars3.githubusercontent.com/u/32689599?v=4"

    @JvmField
    val GITHUB_REPOSITORY_OWNER = GithubRepositoryOwner(
        authorName = DUMMY_REPO_OWNER_NAME,
        authorImageUrl = DUMMY_REPO_OWNER_IMAGE
    )
}
