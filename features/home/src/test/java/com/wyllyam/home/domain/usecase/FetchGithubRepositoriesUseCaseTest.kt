package com.wyllyam.home.domain.usecase

import com.wyllyam.common_test.BaseLifecycleTest
import com.wyllyam.common_test.exception.DummyException
import com.wyllyam.common_test.extensions.coVerifyException
import com.wyllyam.home.data.repository.FetchGithubRepository
import com.wyllyam.home.di.homeModule
import com.wyllyam.home.domain.usecase.FetchGithubRepositoriesUseCase.FetchGithubRepositoryUseCaseException
import com.wyllyam.test.dummies.domain.GithubRepositoriesDummy
import com.wyllyam.test.dummies.domain.usecase.FetchGithubRepositoriesUseCaseDummy.DUMMY_PARAMS_USE_CASE
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.isEmptyOrNullString
import org.hamcrest.Matchers.not
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.koin.core.module.Module
import org.koin.test.inject
import org.koin.test.mock.declareMock

internal class FetchGithubRepositoriesUseCaseTest : BaseLifecycleTest() {

    override val modules: List<Module>
        get() = listOf(homeModule)

    private val useCase: FetchGithubRepositoriesUseCase by inject()

    private val repository: FetchGithubRepository by inject()

    override fun setUp() {
        super.setUp()
        declareMock<FetchGithubRepository>()
    }

    @Test
    fun `should call repository with correct parameters when execute use case`() {
        runBlocking {
            coEvery {
                repository.fetchGithubRepositories(any())
            } returns GithubRepositoriesDummy.DUMMY_REPOSITORIES

            useCase.execute(DUMMY_PARAMS_USE_CASE)

            coVerify(exactly = 1) { repository.fetchGithubRepositories(any()) }
            confirmVerified(repository)
        }
    }

    @Test
    fun `should return github repositories list from repository when execute use case`() {
        runBlocking {
            coEvery {
                repository.fetchGithubRepositories(any())
            } returns GithubRepositoriesDummy.DUMMY_REPOSITORIES

            val data = useCase.execute(DUMMY_PARAMS_USE_CASE)

            assertEquals(
                "Unexpected github repositories list from useCase",
                GithubRepositoriesDummy.DUMMY_REPOSITORIES,
                data
            )

            coVerify(exactly = 1) { repository.fetchGithubRepositories(any()) }
            confirmVerified(repository)
        }
    }

    @Test
    fun `should throw fetch github repositories use case exception when repository throw some exception`() {
        runBlocking {

            coEvery {
                repository.fetchGithubRepositories(any())
            } throws DummyException()

            coVerifyException<FetchGithubRepositoryUseCaseException>(
                executionBlock = {
                    useCase.execute(DUMMY_PARAMS_USE_CASE)
                },
                verificationBlock = { exception ->
                    assertThat(
                        "Unexpected cause from exception.",
                        exception.cause,
                        instanceOf(DummyException::class.java)
                    )
                    assertThat(
                        "Message from exception is null or empty.",
                        exception.message,
                        not(isEmptyOrNullString())
                    )

                    coVerify(exactly = 1) {
                        repository.fetchGithubRepositories(any())
                    }

                    confirmVerified(repository)
                }
            )
        }
    }
}