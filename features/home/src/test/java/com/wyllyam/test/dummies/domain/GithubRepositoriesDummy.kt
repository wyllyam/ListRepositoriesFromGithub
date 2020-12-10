package com.wyllyam.test.dummies.domain

import com.wyllyam.home.domain.model.GithubRepositories
import com.wyllyam.test.dummies.domain.GithubRepositoryDummy.DUMMY_REPOSITORY_LIST

internal object GithubRepositoriesDummy {

    @JvmField
    val DUMMY_REPOSITORIES = GithubRepositories(
        items = DUMMY_REPOSITORY_LIST
    )
}
