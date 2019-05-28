package com.laithlab.cvapp.network

import com.google.gson.annotations.SerializedName

data class CVResponse(
    @SerializedName("name") val name: String,
    @SerializedName("summery") val summery: String,
    @SerializedName("skills") val skills: ArrayList<SkillResponse>,
    @SerializedName("experiences") val experiences: ArrayList<ExperienceResponse>
)

data class SkillResponse(
    @SerializedName("name") val name: String,
    @SerializedName("level") val level: Int
)

data class ExperienceResponse(
    @SerializedName("company_name") val companyName: String,
    @SerializedName("role") val roleName: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("end_date") val endDate: String,
    @SerializedName("company_logo") val companyLogo: String
)