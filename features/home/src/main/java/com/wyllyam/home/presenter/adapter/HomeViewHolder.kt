package com.wyllyam.home.presenter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.wyllyam.extension.loadImage
import com.wyllyam.home.R
import com.wyllyam.home.presenter.model.GithubRepositoryVO
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repository.*

internal class HomeViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindView(githubRepositoryVO: GithubRepositoryVO) {
        val context = containerView.context

        ivRepositoryUserImage.loadImage(githubRepositoryVO.repoOwner.authorImageUrl)

        tvRepositoryUserName.text = context.getString(
            R.string.item_repository_owner_name,
            githubRepositoryVO.repoOwner.authorName
        )
        tvRepositoryName.text = context.getString(
            R.string.item_repository_name,
            githubRepositoryVO.repoName
        )
        tvRepositoryStars.text = context.getString(
            R.string.item_repository_stars,
            githubRepositoryVO.repoStarsCount.toString()
        )
        tvRepositoryForks.text = context.getString(
            R.string.item_repository_forks,
            githubRepositoryVO.repoForksCount.toString()
        )
    }
}