package com.wyllyam.home.di

import com.wyllyam.home.data.remote.api.FetchGithubApi
import com.wyllyam.home.data.repository.FetchGithubDataRepository
import com.wyllyam.home.data.repository.FetchGithubRepository
import com.wyllyam.home.domain.usecase.FetchGithubRepositoryUseCase
import com.wyllyam.home.presenter.ui.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule = module {

    single { get<Retrofit>().create(FetchGithubApi::class.java) }

    single<FetchGithubRepository>{ FetchGithubDataRepository(fetchGithubApi = get()) }

    factory { FetchGithubRepositoryUseCase(fetchGithubRepository = get()) }

    viewModel { HomeViewModel(fetchGithubRepositoryUseCase = get()) }
}