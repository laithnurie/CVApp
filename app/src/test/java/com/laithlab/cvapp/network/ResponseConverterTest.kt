package com.laithlab.cvapp.network

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ResponseConverterTest {

    lateinit var responseConverter: ResponseConverter

    @Before
    fun setup() {
        responseConverter = ResponseConverter()
    }

    @Test
    fun convertValidResponse() {

        val skills = ArrayList<SkillResponse>()
        for (i in 0..3) {
            val skillResponse = mock(SkillResponse::class.java)
            `when`(skillResponse.name).thenReturn("skill no:$i")
            `when`(skillResponse.level).thenReturn(i)
            skills.add(skillResponse)
        }

        val experiences = ArrayList<ExperienceResponse>()
        for (i in 0..4) {
            val experienceResponse = mock(ExperienceResponse::class.java)
            `when`(experienceResponse.companyName).thenReturn("companyName $i")
            `when`(experienceResponse.companyLogo).thenReturn("companyLogo $i")
            `when`(experienceResponse.roleName).thenReturn("roleName $i")
            `when`(experienceResponse.startDate).thenReturn("startDate $i")
            `when`(experienceResponse.endDate).thenReturn("endDate $i")
            experiences.add(experienceResponse)
        }

        val cvResponse = mock(CVResponse::class.java)

        `when`(cvResponse.skills).thenReturn(skills)
        `when`(cvResponse.experiences).thenReturn(experiences)

        `when`(cvResponse.name).thenReturn("Jon Snow")
        `when`(cvResponse.summery).thenReturn("He knows nothing")

        val uiModel = responseConverter.getUIModelFromResponse(cvResponse)

        assertEquals(uiModel.experiences.size, 5)
        assertEquals(uiModel.skills.size, 4)

        val uiExperiences = uiModel.experiences

        for (i in 0 until uiExperiences.size) {
            val experience = uiExperiences[i]
            assertEquals(experience.companyName, "companyName $i")
            assertEquals(experience.roleName, "roleName $i")
            assertEquals(experience.startDate, "startDate $i")
            assertEquals(experience.endDate, "endDate $i")
            assertEquals(experience.companyLogo, "companyLogo $i")
        }

        val uiSkills = uiModel.skills
        for (i in 0 until uiSkills.size) {
            val skill = uiSkills[i]
            assertEquals(skill.level, i)
            assertEquals(skill.name, "skill no:$i")
        }
    }
}