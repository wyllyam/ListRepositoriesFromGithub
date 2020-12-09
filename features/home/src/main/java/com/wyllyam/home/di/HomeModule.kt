package com.wyllyam.home.di

import com.wyllyam.home.data.remote.api.Api
import com.wyllyam.home.data.repository.FetchGithubDataRepository
import com.wyllyam.home.data.repository.FetchGithubRepository
import com.wyllyam.home.domain.usecase.FetchGithubRepositoryUseCase
import com.wyllyam.home.presenter.adapter.HomeAdapter
import com.wyllyam.home.presenter.ui.HomeFragment
import com.wyllyam.home.presenter.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

import retrofit2.Retrofit

val homeModule = module {

    single { get<Retrofit>().create(Api::class.java) }

    single<FetchGithubRepository>{ FetchGithubDataRepository(api = get()) }

    factory { FetchGithubRepositoryUseCase(fetchGithubRepository = get()) }

    viewModel { HomeViewModel(fetchGithubRepositoryUseCase = get()) }

    scope(named<HomeFragment>()){
        scoped { HomeAdapter() }
    }
}