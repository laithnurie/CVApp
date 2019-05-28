package com.laithlab.cvapp.main

import com.laithlab.cvapp.network.CVAPI
import com.laithlab.cvapp.network.ResponseConverter
import io.reactivex.Single

class CVRepo(private val cvAPI: CVAPI, private val responseConverter: ResponseConverter) {

    fun getCV(): Single<MainUIModel> {
        return cvAPI.getCV()
            .flatMap {
                return@flatMap Single.just(responseConverter.getUIModelFromResponse(it))
            }
    }
}
