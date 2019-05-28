package com.laithlab.cvapp.network

import com.laithlab.cvapp.main.MainUIModel
import com.laithlab.cvapp.main.ExperienceUIModel
import com.laithlab.cvapp.main.SkillUIModel

class ResponseConverter {

    fun getUIModelFromResponse(cvResponse: CVResponse): MainUIModel {
        val skills = getSkills(cvResponse.skills)
        val experiences = getExperiences(cvResponse.experiences)
        return MainUIModel(cvResponse.name, cvResponse.summery, skills, experiences)
    }

    private fun getSkills(skillsResponse: ArrayList<SkillResponse>): ArrayList<SkillUIModel> {
        val skills = ArrayList<SkillUIModel>()
        skillsResponse.forEach {
            skills.add(SkillUIModel(it.name, it.level))
        }
        return skills
    }

    private fun getExperiences(experiencesResponse: ArrayList<ExperienceResponse>): ArrayList<ExperienceUIModel> {
        val experiences = ArrayList<ExperienceUIModel>()

        experiencesResponse.forEach {
            experiences.add(
                ExperienceUIModel(
                    it.companyName, it.roleName,
                    it.startDate, it.endDate,
                    it.companyLogo
                )
            )
        }

        return experiences
    }
}