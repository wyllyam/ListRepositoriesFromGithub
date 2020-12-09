package com.wyllyam.home.presenter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.wyllyam.extension.loadImage
import com.wyllyam.home.R
import com.wyllyam.home.databinding.ItemRepositoryBinding
import com.wyllyam.home.presenter.model.GithubRepositoryVO

internal class HomeViewHolder(private val itemRepositoryBinding: ItemRepositoryBinding) :
    RecyclerView.ViewHolder(itemRepositoryBinding.root) {

    fun bindView(githubRepositoryVO: GithubRepositoryVO) {
        val context = itemRepositoryBinding.root.context

        itemRepositoryBinding.ivRepositoryUserImage.loadImage(githubRepositoryVO.repoOwner.authorImageUrl)

        itemRepositoryBinding.tvRepositoryUserName.text = context.getString(
            R.string.item_repository_owner_name,
            githubRepositoryVO.repoOwner.authorName
        )
        itemRepositoryBinding.tvRepositoryName.text = context.getString(
            R.string.item_repository_name,
            githubRepositoryVO.repoName
        )
        itemRepositoryBinding.tvRepositoryStars.text = context.getString(
            R.string.item_repository_stars,
            githubRepositoryVO.repoStarsCount.toString()
        )
        itemRepositoryBinding.tvRepositoryForks.text = context.getString(
            R.string.item_repository_forks,
            githubRepositoryVO.repoForksCount.toString()
        )
    }
}