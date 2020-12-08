package com.wyllyam.home.presenter.ui

import androidx.lifecycle.MutableLiveData
import com.wyllyam.BaseViewModel
import com.wyllyam.extension.toLiveData
import com.wyllyam.home.domain.usecase.FetchGithubRepositoryUseCase
import com.wyllyam.home.domain.usecase.FetchGithubRepositoryUseCase.FetchGithubRepositoryUseCaseException
import com.wyllyam.home.presenter.mapper.toPresenter
import com.wyllyam.home.presenter.model.GithubRepositoriesVO
import com.wyllyam.home.presenter.ui.HomeViewModel.ViewState.*
import timber.log.Timber

internal class HomeViewModel(private val fetchGithubRepositoryUseCase: FetchGithubRepositoryUseCase) :
    BaseViewModel() {

    private val _loadingState = MutableLiveData<ViewState>()
    val loadingState = _loadingState.toLiveData()

    private val _listResultRepositories = MutableLiveData<GithubRepositoriesVO>()
    val listResultRepositories = _listResultRepositories.toLiveData()

    init {
        _loadingState.postValue(LOADING)
    }

    fun loadRepositories(page: Int) {
        launchIO {
            val viewState = try {
                val params = FetchGithubRepositoryUseCase.Params(page = page)
                val result = fetchGithubRepositoryUseCase.execute(params).toPresenter()
                _listResultRepositories.postValue(result)
                LOADED
            } catch (e: FetchGithubRepositoryUseCaseException) {
                Timber.e("Failed to fetch repositories")
                ERROR
            }
            _loadingState.postValue(viewState)
        }
    }

    sealed class ViewState {
        object LOADING : ViewState()
        object LOADED : ViewState()
        object ERROR : ViewState()
    }
}