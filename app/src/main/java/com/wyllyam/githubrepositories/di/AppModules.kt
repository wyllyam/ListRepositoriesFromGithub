package com.wyllyam.githubrepositories.di

import com.wyllyam.common.di.commonModule
import com.wyllyam.common_test.di.commonTestModule
import com.wyllyam.home.di.homeModule
import com.wyllyam.network.di.networkModule

val appModules = listOf(homeModule, commonModule, commonTestModule, networkModule)