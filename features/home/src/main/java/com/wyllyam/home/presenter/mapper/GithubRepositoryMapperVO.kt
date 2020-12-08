package com.wyllyam.home.presenter.mapper

import com.wyllyam.home.domain.model.GithubRepository
import com.wyllyam.home.presenter.model.GithubRepositoryVO

internal fun GithubRepository.toPresenter(): GithubRepositoryVO {
    return GithubRepositoryVO(
        repoName = repoName,
        repoStarsCount = repoStarsCount,
        repoForksCount = repoForksCount,
        repoOwner = repoOwner.toPresenter()
    )
}

internal fun List<GithubRepository>.toPresenter(): List<GithubRepositoryVO> {
    return map { it.toPresenter() }
}
