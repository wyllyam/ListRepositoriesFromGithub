package com.wyllyam.home.data.remote.api

import com.wyllyam.home.data.remote.model.GithubRepositoriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface FetchGithubApi {

//    @GET("/search/repositories?q=language:kotlin&sort=stars&page=1")
    @GET("/search/repositories?q=language:kotlin")
    suspend fun fetchGithubRepositoryList(
        @Query("sort") filter: String,
        @Query("page") page: Int,
        @Query("per_page") rows: Int
    ): Response<GithubRepositoriesResponse>
}