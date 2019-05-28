package com.laithlab.cvapp.di

import com.laithlab.cvapp.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}