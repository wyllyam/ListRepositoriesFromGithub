package com.wyllyam.test.dummies.domain

import com.wyllyam.home.domain.model.GithubRepository
import com.wyllyam.test.dummies.domain.GithubRepositoryOwnerDummy.GITHUB_REPOSITORY_OWNER

internal object GithubRepositoryDummy {

    private const val DUMMY_REPO_NAME = "dummyRepoName"
    private const val DUMMY_REPO_STARS = 1234L
    private const val DUMMY_REPO_FORKS = 1234L

    @JvmField
    val GITHUB_REPOSITORY = GithubRepository(
        repoName = DUMMY_REPO_NAME,
        repoStarsCount = DUMMY_REPO_STARS,
        repoForksCount = DUMMY_REPO_FORKS,
        repoOwner = GITHUB_REPOSITORY_OWNER
    )

    @JvmField
    val DUMMY_REPOSITORY_LIST = listOf(GITHUB_REPOSITORY, GITHUB_REPOSITORY, GITHUB_REPOSITORY)
}
