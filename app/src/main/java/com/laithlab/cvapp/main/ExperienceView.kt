package com.laithlab.cvapp.main

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.laithlab.cvapp.R
import com.laithlab.cvapp.loadImage
import kotlinx.android.synthetic.main.experience_view.view.*

class ExperienceView : LinearLayout {


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        View.inflate(context, R.layout.experience_view, this)
        orientation = HORIZONTAL
    }

    fun setup(experience: ExperienceUIModel) {
        background_img.loadImage(experience.companyLogo)

        company_name.text = experience.companyName
        role_name.text = experience.roleName
        duration.text = "${experience.startDate} to ${experience.endDate}"

    }
}