package com.wyllyam.home.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class GithubRepositoryOwnerResponse(
    @SerializedName("avatar_url")
    var authorImageUrl: String
) : Parcelable