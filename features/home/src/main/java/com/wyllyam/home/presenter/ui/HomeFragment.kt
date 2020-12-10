package com.wyllyam.home.presenter.ui

import android.os.Bundle
import android.widget.Toast
import com.wyllyam.BaseFragment
import com.wyllyam.extension.gone
import com.wyllyam.extension.observe
import com.wyllyam.extension.visible
import com.wyllyam.home.R
import com.wyllyam.home.presenter.adapter.HomeAdapter
import com.wyllyam.home.presenter.adapter.PaginateScrollListener
import com.wyllyam.home.presenter.ui.HomeViewModel.ViewState.*
import com.wyllyam.network.extension.isNetworkAvailable
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

    private val adapter: HomeAdapter by inject(fromScope = true)

    private lateinit var paginateScrollListener: PaginateScrollListener

    override fun setupView(savedInstanceState: Bundle?) {
        super.setupView(savedInstanceState)
        loadData()
    }

    override fun setupViewListeners() {
        super.setupViewListeners()

        paginateScrollListener = object : PaginateScrollListener() {
            override val isLoading: Boolean get() = viewModel.isLoading

            override fun loadMore(page: Int) {
               loadData(page = page)
            }
        }

        with(rvRepositories) {
            adapter = this@HomeFragment.adapter
            addOnScrollListener(paginateScrollListener)
        }

        ivButtonReload.setOnClickListener {
            loadingState()
            loadData()
        }
    }

    override fun setupObservers() {
        super.setupObservers()

        observe(viewModel.listResultRepositories) { result ->
            adapter.submitList(result.items)
        }

        observe(viewModel.loadingState) { state ->
            when (state) {
                LOADING -> loadingState()
                LOADED -> loadedState()
                ERROR -> errorState()
            }
        }
    }

    private fun loadingState() {
        pbLoadList.visible()
        ivButtonReload.gone()
        rvRepositories.gone()
    }

    private fun loadedState() {
        viewModel.isLoading = false
        viewModel.isPaginating = false

        pbLoadList.gone()
        ivButtonReload.gone()
        rvRepositories.visible()
    }

    private fun errorState() {
        pbLoadList.gone()
        rvRepositories.gone()
        ivButtonReload.visible()
    }

    private fun loadData(page: Int = 0) {
        if (requireContext().isNetworkAvailable()) {
            viewModel.loadRepositories(page = page)
        } else {
            if (page == 0) {
                errorState()
            }
            Toast.makeText(requireContext(), getString(R.string.no_connection), Toast.LENGTH_SHORT)
                .show()
        }
    }
}