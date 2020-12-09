package com.wyllyam.home.data.remote.api

import com.wyllyam.home.data.remote.model.GithubRepositoriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface Api {

    @GET("/search/repositories?q=language:kotlin&sort=stars&per_page=20")
    suspend fun fetchGithubRepositories(@Query("page") page: Int): Response<GithubRepositoriesResponse>
}