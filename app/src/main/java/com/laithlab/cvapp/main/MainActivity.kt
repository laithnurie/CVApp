package com.laithlab.cvapp.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import com.laithlab.cvapp.App
import com.laithlab.cvapp.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).mainComponent.inject(this)

        skills_list.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        experiences_list.layoutManager = LinearLayoutManager(this)

        disposables.add(
            viewModel.getCV()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.v("lnln", it.toString())
                    handleResponse(it)
                }, {
                    Log.v("lnln", it.toString())
                })
        )
    }

    override fun onPause() {
        super.onPause()
        disposables.clear()
    }

    private fun handleResponse(uiModel: MainUIModel) {
        name.text = uiModel.name
        summery.text = uiModel.summery
        skills_list.adapter = SkillsAdapter(this, uiModel.skills)
        experiences_list.adapter = ExperiencesAdapter(this, uiModel.experiences)
    }
}