package com.wyllyam.home.presenter.mapper

import com.wyllyam.home.domain.model.GithubRepositories
import com.wyllyam.home.presenter.model.GithubRepositoriesVO

internal fun GithubRepositories.toPresenter(): GithubRepositoriesVO {
    return GithubRepositoriesVO(
        items = items.toPresenter()
    )
}

internal fun List<GithubRepositories>.toPresenter(): List<GithubRepositoriesVO> {
    return map { it.toPresenter() }
}

