package com.wyllyam.home.presenter.ui

import android.os.Bundle
import com.wyllyam.BaseFragment
import com.wyllyam.extension.observe
import com.wyllyam.home.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

internal class HomeFragment: BaseFragment(R.layout.fragment_home){

   private val viewModel: HomeViewModel by viewModel()

   override fun setupView(savedInstanceState: Bundle?) {
      super.setupView(savedInstanceState)
      viewModel.loadRepositories(0)
   }

   override fun setupObservers() {
      super.setupObservers()

      observe(viewModel.listResultRepositories){
         texts.text = it.toString()
      }
   }
}