package com.wyllyam.test.dummies.presenter.viewmodel

import com.wyllyam.home.presenter.model.GithubRepositoryOwnerVO

internal object GithubRepositoryOwnerVODummy {

    private const val DUMMY_REPO_OWNER_NAME_VO = "dummyRepoOwnerName"
    private const val DUMMY_REPO_OWNER_IMAGE_VO = "https://avatars3.githubusercontent.com/u/32689599?v=4"

    @JvmField
    val GITHUB_REPOSITORY_OWNER_VO = GithubRepositoryOwnerVO(
        authorName = DUMMY_REPO_OWNER_NAME_VO,
        authorImageUrl = DUMMY_REPO_OWNER_IMAGE_VO
    )
}
