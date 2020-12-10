package com.wyllyam.test.dummies.domain.usecase

import com.wyllyam.home.domain.usecase.FetchGithubRepositoriesUseCase
import com.wyllyam.test.dummies.data.GithubRepositoriesResponseDummy

internal object FetchGithubRepositoriesUseCaseDummy {

    val DUMMY_PARAMS_USE_CASE =
        FetchGithubRepositoriesUseCase.Params(GithubRepositoriesResponseDummy.DUMMY_PAGE)

}
