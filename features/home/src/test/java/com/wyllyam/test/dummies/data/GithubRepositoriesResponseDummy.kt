package com.wyllyam.test.dummies.data

import com.wyllyam.home.data.remote.model.GithubRepositoriesResponse
import com.wyllyam.test.dummies.data.GithubRepositoryResponseDummy.DUMMY_REPOSITORY_LIST_RESPONSE

internal object GithubRepositoriesResponseDummy {

    const val DUMMY_PAGE = 0

    @JvmField
    val DUMMY_REPOSITORIES_RESPONSE = GithubRepositoriesResponse(
        items = DUMMY_REPOSITORY_LIST_RESPONSE
    )
}
