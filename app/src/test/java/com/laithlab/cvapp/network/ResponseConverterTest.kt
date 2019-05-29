package com.laithlab.cvapp.network

import com.laithlab.cvapp.TestHelper
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ResponseConverterTest {

    lateinit var responseConverter: ResponseConverter

    @Before
    fun setup() {
        responseConverter = ResponseConverter()
    }

    @Test
    fun convertValidResponse() {
        val cvResponse = TestHelper.getMockedResponse()
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