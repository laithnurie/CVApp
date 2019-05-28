package com.laithlab.cvapp.network

import io.reactivex.Single
import retrofit2.http.GET

interface CVAPI {
    @GET("4543f02da001c483186f2a2c53645b89/raw/e90952d518c0b7b14b2edeb7144d0adb1404e3e8/laith_cv.json")
    fun getCV(): Single<CVResponse>
}
