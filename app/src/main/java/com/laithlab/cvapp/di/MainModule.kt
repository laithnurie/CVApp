package com.laithlab.cvapp.di

import com.laithlab.cvapp.network.CVAPI
import com.laithlab.cvapp.main.CVRepo
import com.laithlab.cvapp.main.MainViewModel
import com.laithlab.cvapp.network.ResponseConverter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MainModule {

    companion object {
        private const val CVAPI_BASE_URL = "https://gist.githubusercontent.com/laithnurie/"
    }

    @Provides
    @Singleton
    internal fun provideMainViewModel(cvRepo: CVRepo): MainViewModel {
        return MainViewModel(cvRepo)
    }

    @Provides
    @Singleton
    internal fun provideCVRepo(cvAPI: CVAPI, converter: ResponseConverter): CVRepo {
        return CVRepo(cvAPI, converter)
    }

    @Provides
    @Singleton
    internal fun provideCVApi(builder: Retrofit.Builder): CVAPI {
        val retrofit = builder.baseUrl(CVAPI_BASE_URL).build()
        return retrofit.create(CVAPI::class.java)
    }

    @Provides
    @Singleton
    internal fun provideResponseConverter(): ResponseConverter {
        return ResponseConverter()
    }

    @Provides
    @Singleton
    internal fun retrofitBuilder(): Retrofit.Builder {
        val gsonConverterFactory = GsonConverterFactory.create()
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
    }
}
