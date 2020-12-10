package com.wyllyam.home.presenter.viewmodel

import com.wyllyam.common.di.commonModule
import com.wyllyam.common_test.BaseLifecycleTest
import com.wyllyam.common_test.extensions.declare
import com.wyllyam.home.di.homeModule
import com.wyllyam.home.domain.usecase.FetchGithubRepositoriesUseCase
import com.wyllyam.home.presenter.ui.HomeViewModel
import com.wyllyam.home.presenter.ui.HomeViewModel.ViewState
import com.wyllyam.test.dummies.data.GithubRepositoriesResponseDummy.DUMMY_PAGE
import com.wyllyam.test.dummies.domain.GithubRepositoriesDummy
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.core.module.Module
import org.koin.test.inject

internal class HomeViewModelTest : BaseLifecycleTest() {

    override val modules: List<Module>
        get() = listOf(homeModule, commonModule)

    private val useCase: FetchGithubRepositoriesUseCase by inject()
    private val viewModel: HomeViewModel by inject()

    override fun setUp() {
        super.setUp()
        declare {
            single(override = true) { mockk<FetchGithubRepositoriesUseCase>() }
        }

        coEvery { useCase.execute(any()) } returns GithubRepositoriesDummy.DUMMY_REPOSITORIES
    }

    @Test
    fun `should call fetch github repositories when viewModel is created`() {
        runBlocking {

            viewModel.loadRepositories(DUMMY_PAGE)

            coVerify(exactly = 1) { useCase.execute(any()) }

            confirmVerified(useCase)
        }
    }

    @Test
    fun `should update github repositories state to loaded when fetch github repositories from viewModel`() {
        runBlocking {

            viewModel.loadRepositories(DUMMY_PAGE)

            val observer = createMockedObserver<ViewState>()
            viewModel.loadingState.observe(lifecycleOwner, observer)
            resumeLifecycle()

            coVerify(exactly = 1) { observer.onChanged(ViewState.LOADED) }

            confirmVerified(observer)
        }
    }

    @Test
    fun `should update view state live data github repositories to loading and error when fetch github repositories from viewModel`() {
        runBlocking {

            coEvery { useCase.execute(any()) } throws FetchGithubRepositoriesUseCase.FetchGithubRepositoryUseCaseException()

            val stateObserver = createMockedObserver<ViewState>()
            viewModel.loadingState.observe(lifecycleOwner, stateObserver)

            resumeLifecycle()
            viewModel.loadRepositories(DUMMY_PAGE)

            verifySequence {
                stateObserver.onChanged(ViewState.LOADING)
                stateObserver.onChanged(ViewState.ERROR)
            }

            confirmVerified(stateObserver)
        }
    }
}