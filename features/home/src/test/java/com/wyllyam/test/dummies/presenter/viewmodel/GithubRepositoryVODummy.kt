package com.wyllyam.test.dummies.presenter.viewmodel

import com.wyllyam.home.presenter.model.GithubRepositoryVO
import com.wyllyam.test.dummies.presenter.viewmodel.GithubRepositoryOwnerVODummy.GITHUB_REPOSITORY_OWNER_VO

internal object GithubRepositoryVODummy {

    private const val DUMMY_REPO_NAME_VO = "dummyRepoName"
    private const val DUMMY_REPO_STARS_VO = 1234L
    private const val DUMMY_REPO_FORKS_VO = 1234L

    @JvmField
    val GITHUB_REPOSITORY_VO = GithubRepositoryVO(
        repoName = DUMMY_REPO_NAME_VO,
        repoStarsCount = DUMMY_REPO_STARS_VO,
        repoForksCount = DUMMY_REPO_FORKS_VO,
        repoOwner = GITHUB_REPOSITORY_OWNER_VO
    )

    @JvmField
    val DUMMY_REPOSITORY_LIST_VO = listOf(GITHUB_REPOSITORY_VO, GITHUB_REPOSITORY_VO, GITHUB_REPOSITORY_VO)
}
