package com.laithlab.cvapp.main

import io.reactivex.Single

class MainViewModel(private val cvRepo: CVRepo) {

    fun getCV(): Single<MainUIModel> {
        return cvRepo.getCV()
    }
}
