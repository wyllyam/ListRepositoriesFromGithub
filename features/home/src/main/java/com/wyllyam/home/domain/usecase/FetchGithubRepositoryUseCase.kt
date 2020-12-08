package com.wyllyam.home.domain.usecase

import com.wyllyam.common.domain.BaseUseCase
import com.wyllyam.home.data.repository.FetchGithubRepository
import com.wyllyam.home.domain.model.GithubRepositories
import com.wyllyam.network.exception.NetworkException
import timber.log.Timber

internal class FetchGithubRepositoryUseCase (private val fetchGithubRepository: FetchGithubRepository):
    BaseUseCase<FetchGithubRepositoryUseCase.Params, GithubRepositories> {

    override suspend fun execute(params: Params?): GithubRepositories{
        try{
            requireNotNull(params) {
                "Failed to execute FetchGithubRepositoryUseCase. Params must not be null."
            }

            return fetchGithubRepository.fetchGithubRepositoryList(page = params.page)
        }catch (e: NetworkException){
            throw FetchGithubRepositoryUseCaseException("Failed to fetch repositories list", ).also { exception ->
                Timber.e(exception)
            }
        }
    }

    data class Params(
        val page: Int
    )

    class FetchGithubRepositoryUseCaseException @JvmOverloads constructor(
        message: String? = null,
        throwable: Throwable? = null
    ) : Exception(message, throwable)
}