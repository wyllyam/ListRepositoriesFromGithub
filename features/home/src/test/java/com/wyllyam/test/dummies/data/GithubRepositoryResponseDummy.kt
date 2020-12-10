package com.wyllyam.test.dummies.data

import com.wyllyam.home.data.remote.model.GithubRepositoryResponse
import com.wyllyam.test.dummies.data.GithubRepositoryOwnerResponseDummy.GITHUB_REPOSITORY_OWNER_RESPONSE

internal object GithubRepositoryResponseDummy {

    private const val DUMMY_REPO_NAME_RESPONSE = "dummyRepoName"
    private const val DUMMY_REPO_STARS_RESPONSE = 1234L
    private const val DUMMY_REPO_FORKS_RESPONSE = 1234L

    @JvmField
    val GITHUB_REPOSITORY_RESPONSE = GithubRepositoryResponse(
        repoName = DUMMY_REPO_NAME_RESPONSE,
        repoStarsCount = DUMMY_REPO_STARS_RESPONSE,
        repoForksCount = DUMMY_REPO_FORKS_RESPONSE,
        repoOwner = GITHUB_REPOSITORY_OWNER_RESPONSE
    )

    @JvmField
    val DUMMY_REPOSITORY_LIST_RESPONSE =
        listOf(GITHUB_REPOSITORY_RESPONSE, GITHUB_REPOSITORY_RESPONSE, GITHUB_REPOSITORY_RESPONSE)
}
