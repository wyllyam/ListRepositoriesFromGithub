package com.wyllyam.home.data.repository

import com.wyllyam.common_test.BaseLifecycleTest
import com.wyllyam.home.data.remote.api.Api
import com.wyllyam.home.di.homeModule
import com.wyllyam.network.exception.NetworkException
import com.wyllyam.test.dummies.data.GithubRepositoriesResponseDummy
import com.wyllyam.test.dummies.data.GithubRepositoriesResponseDummy.DUMMY_PAGE
import com.wyllyam.test.dummies.domain.GithubRepositoriesDummy
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.core.module.Module
import org.koin.test.inject
import org.koin.test.mock.declareMock
import retrofit2.Response
import java.net.HttpURLConnection
import java.net.UnknownHostException

internal class FetchGithubDataRepositoryTest : BaseLifecycleTest() {

    override val modules: List<Module>
        get() = listOf(homeModule)

    private val repository: FetchGithubRepository by inject()

    private val api: Api by inject()

    override fun setUp() {
        super.setUp()
        declareMock<Api>()
    }

    @Test
    fun `should call api with correct parameters when fetch github repository`() {
        runBlocking {
            coEvery {
                api.fetchGithubRepositories(any())
            } returns Response.success(GithubRepositoriesResponseDummy.DUMMY_REPOSITORIES_RESPONSE)

            repository.fetchGithubRepositories(DUMMY_PAGE)

            coVerify(exactly = 1) {
                api.fetchGithubRepositories(any())
            }

            confirmVerified(api)
        }
    }

    @Test
    fun `should return a list of repositories from api when fetch github repository`() {
        runBlocking {
            coEvery {
                api.fetchGithubRepositories(any())
            } returns Response.success(GithubRepositoriesResponseDummy.DUMMY_REPOSITORIES_RESPONSE)

            val data = repository.fetchGithubRepositories(DUMMY_PAGE)

            assertEquals(
                "Unexpected repositories list returned from repository.",
                GithubRepositoriesDummy.DUMMY_REPOSITORIES,
                data
            )

            coVerify(exactly = 1) {
                api.fetchGithubRepositories(any())
            }

            confirmVerified(api)
        }
    }

    @Test(expected = NetworkException.InternalError::class)
    fun `should throw a network exception internal error when fetch github repositories from api return internal error`() {
        runBlocking {
            coEvery {
                api.fetchGithubRepositories(any())
            } returns  Response.error(HttpURLConnection.HTTP_INTERNAL_ERROR, mockk(relaxed = true))

            repository.fetchGithubRepositories(DUMMY_PAGE)
        }
    }

    @Test(expected = UnknownHostException::class)
    fun `should throw same exception from api when fetch github repositories from api throw an exception`() {
        runBlocking {
            coEvery {
                api.fetchGithubRepositories(any())
            } throws UnknownHostException()

            repository.fetchGithubRepositories(DUMMY_PAGE)
        }
    }
}