package com.wyllyam.githubrepositories

import android.app.Application
import com.wyllyam.githubrepositories.di.appModules
import com.wyllyam.koin.KoinController

open class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinController.start(this, appModules)
    }
}