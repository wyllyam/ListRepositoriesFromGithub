package com.wyllyam.test.dummies.presenter.viewmodel

import com.wyllyam.home.presenter.model.GithubRepositoriesVO
import com.wyllyam.test.dummies.presenter.viewmodel.GithubRepositoryVODummy.DUMMY_REPOSITORY_LIST_VO

internal object GithubRepositoriesVODummy {

    @JvmField
    val DUMMY_REPOSITORIES_VO = GithubRepositoriesVO(
        items = DUMMY_REPOSITORY_LIST_VO
    )
}
