package com.wyllyam.network.base

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GithubListResponse<T>(
    @SerializedName("data") var data: List<T> = ArrayList()
) : Serializable