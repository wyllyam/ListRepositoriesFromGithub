package com.wyllyam.home.presenter.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.wyllyam.BaseViewModel
import com.wyllyam.extension.toLiveData
import com.wyllyam.home.domain.usecase.FetchGithubRepositoriesUseCase
import com.wyllyam.home.domain.usecase.FetchGithubRepositoriesUseCase.FetchGithubRepositoryUseCaseException
import com.wyllyam.home.presenter.mapper.toPresenter
import com.wyllyam.home.presenter.model.GithubRepositoriesVO
import com.wyllyam.home.presenter.ui.HomeViewModel.ViewState.*
import timber.log.Timber

internal class HomeViewModel(private val fetchGithubRepositoriesUseCase: FetchGithubRepositoriesUseCase) :
    BaseViewModel() {

    private val _loadingState = MutableLiveData<ViewState>()
    val loadingState = _loadingState.toLiveData()

    private val _listResultRepositories = MutableLiveData<GithubRepositoriesVO>()
    val listResultRepositories = _listResultRepositories.toLiveData()

    var isPaginating = false
        internal set

    var isLoading = false
        internal set

    var currentPage: Int = 0
        private set

    init {
        _loadingState.postValue(LOADING)
    }

    fun loadRepositories(page: Int) {
        currentPage = page
        isLoading = true

        if (page != 0) {
            isPaginating = true
        }

        launchIO {
            val viewState = try {
                val params = FetchGithubRepositoriesUseCase.Params(page = page)
                val result = fetchGithubRepositoriesUseCase.execute(params).toPresenter()
                _listResultRepositories.postValue(result)
                LOADED
            } catch (e: FetchGithubRepositoryUseCaseException) {
                isLoading = false
                isPaginating = false
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