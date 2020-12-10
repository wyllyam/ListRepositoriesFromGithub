package com.wyllyam.test.dummies.data

import com.wyllyam.home.data.remote.model.GithubRepositoryOwnerResponse

internal object GithubRepositoryOwnerResponseDummy {

    private const val DUMMY_REPO_OWNER_NAME_RESPONSE = "dummyRepoOwnerName"
    private const val DUMMY_REPO_OWNER_IMAGE_RESPONSE = "https://avatars3.githubusercontent.com/u/32689599?v=4"

    @JvmField
    val GITHUB_REPOSITORY_OWNER_RESPONSE = GithubRepositoryOwnerResponse(
        authorName = DUMMY_REPO_OWNER_NAME_RESPONSE,
        authorImageUrl = DUMMY_REPO_OWNER_IMAGE_RESPONSE
    )
}
