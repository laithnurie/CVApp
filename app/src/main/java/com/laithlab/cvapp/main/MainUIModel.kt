package com.laithlab.cvapp.main

data class MainUIModel(
    val name: String,
    val summery: String,
    val skills: ArrayList<SkillUIModel>,
    val experiences: ArrayList<ExperienceUIModel>
)

data class SkillUIModel(val name: String, val level: Int)

data class ExperienceUIModel(
    val companyName: String,
    val roleName: String,
    val startDate: String,
    val endDate: String,
    val companyLogo: String
)