package com.wyllyam.home.presenter.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

internal abstract class PaginateScrollListener(val offset: Int = OFFSET) : RecyclerView.OnScrollListener() {

    var currentPage: Int = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = recyclerView.layoutManager

        val visibleItemCount = layoutManager?.childCount ?: 0
        val totalItemCount = layoutManager?.itemCount ?: 0

        var firstVisibleItemPosition = 0

        when (layoutManager) {
            is LinearLayoutManager -> {
                firstVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
            }
        }

        if (!isLoading &&
            visibleItemCount + firstVisibleItemPosition + offset >= totalItemCount &&
            firstVisibleItemPosition >= 0
        ) {
            loadMore(++currentPage)
        }
    }

    abstract val isLoading: Boolean

    abstract fun loadMore(page: Int)

    companion object {
        const val OFFSET = 5
    }
}
