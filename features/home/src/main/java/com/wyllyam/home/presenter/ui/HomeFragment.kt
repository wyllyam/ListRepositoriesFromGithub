package com.wyllyam.home.presenter.ui

import android.os.Bundle
import com.wyllyam.BaseFragment
import com.wyllyam.extension.observe
import com.wyllyam.home.R
import com.wyllyam.home.presenter.adapter.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class HomeFragment : BaseFragment(R.layout.fragment_home){

   private val viewModel: HomeViewModel by viewModel()

   private val adapter: HomeAdapter by inject(fromScope = true)

   override fun setupView(savedInstanceState: Bundle?) {
      super.setupView(savedInstanceState)
      viewModel.loadRepositories(0)

      with(rvRepositories){
         adapter = this@HomeFragment.adapter
      }
   }

   override fun setupObservers() {
      super.setupObservers()

      observe(viewModel.listResultRepositories){ result ->
         adapter.submitList(result.items)
      }
   }
}