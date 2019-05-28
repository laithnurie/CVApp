package com.laithlab.cvapp

import android.app.Application
import com.laithlab.cvapp.di.DaggerMainComponent
import com.laithlab.cvapp.di.MainComponent

class App : Application() {

    lateinit var mainComponent: MainComponent

    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent.create()
    }
}