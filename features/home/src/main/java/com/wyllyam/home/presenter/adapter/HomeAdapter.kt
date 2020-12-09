package com.wyllyam.home.presenter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wyllyam.extension.inflate
import com.wyllyam.home.R
import com.wyllyam.home.presenter.model.GithubRepositoryVO

internal class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<GithubRepositoryVO> = mutableListOf()
        protected set

    var isPaginating: Boolean = false

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_PAGINATE) {
            HolderLoading(parent.inflate(R.layout.item_loading))
        } else {
            return HomeViewHolder(parent.inflate(R.layout.item_repository))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeViewHolder) {
            holder.bindView(list[position])
        }
    }

    override fun getItemViewType(position: Int) = if (list.size - 1 == position && isPaginating) {
        VIEW_TYPE_PAGINATE
    } else {
        VIEW_TYPE_ITEM
    }

    override fun getItemCount() = list.size

    override fun getItemId(position: Int): Long {
        return if (isPaginateItem(position)) {
            System.currentTimeMillis()
        } else {
            position.toLong()
        }
    }

    fun submitList(newList: List<GithubRepositoryVO>) {
        list.addAll(newList)
        list = list.distinct().toMutableList()
        notifyDataSetChanged()
    }

    private fun isPaginateItem(position: Int): Boolean = isPaginating && position >= list.size

    companion object {
        const val VIEW_TYPE_PAGINATE = 123456789
        const val VIEW_TYPE_ITEM = 987654321
    }
}