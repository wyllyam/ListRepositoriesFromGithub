package com.wyllyam.home.presenter.mapper

import com.wyllyam.home.domain.model.GithubRepositoryOwner
import com.wyllyam.home.presenter.model.GithubRepositoryOwnerVO

internal fun GithubRepositoryOwner.toPresenter(): GithubRepositoryOwnerVO {
    return GithubRepositoryOwnerVO(
        authorName = authorName,
        authorImageUrl = authorImageUrl
    )
}

internal fun List<GithubRepositoryOwner>.toPresenter(): List<GithubRepositoryOwnerVO> {
    return map { it.toPresenter() }
}
