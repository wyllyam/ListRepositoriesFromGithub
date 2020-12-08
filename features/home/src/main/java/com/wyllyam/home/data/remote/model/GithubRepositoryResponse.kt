package com.wyllyam.home.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class GithubRepositoryResponse(
    @SerializedName("name")
    var repoName: String,
    @SerializedName("stargazers_count")
    var repoStarsCount: Long,
    @SerializedName("forks_count")
    var repoForksCount: Long,
    @SerializedName("owner")
    var repoOwner: GithubRepositoryOwnerResponse
) : Parcelable