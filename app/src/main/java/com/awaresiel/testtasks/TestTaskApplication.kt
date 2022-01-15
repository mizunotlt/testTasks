package com.awaresiel.testtasks

import android.app.Application
import android.content.Context
import com.awaresiel.testtasks.di.components.AppComponent
import com.awaresiel.testtasks.di.components.DaggerAppComponent

class TestTaskApplication: Application(){

    companion object {
        lateinit var appContext: Context
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        appComponent = initDagger()
    }

    private fun initDagger(): AppComponent {
        return DaggerAppComponent.builder()
            .build()
    }

}