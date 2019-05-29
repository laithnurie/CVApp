package com.laithlab.cvapp

import com.laithlab.cvapp.network.CVResponse
import com.laithlab.cvapp.network.ExperienceResponse
import com.laithlab.cvapp.network.SkillResponse
import org.mockito.Mockito

class TestHelper {
    companion object {

        fun getMockedResponse(): CVResponse {
            val skills = ArrayList<SkillResponse>()
            for (i in 0..3) {
                val skillResponse = Mockito.mock(SkillResponse::class.java)
                Mockito.`when`(skillResponse.name).thenReturn("skill no:$i")
                Mockito.`when`(skillResponse.level).thenReturn(i)
                skills.add(skillResponse)
            }

            val experiences = ArrayList<ExperienceResponse>()
            for (i in 0..4) {
                val experienceResponse = Mockito.mock(ExperienceResponse::class.java)
                Mockito.`when`(experienceResponse.companyName).thenReturn("companyName $i")
                Mockito.`when`(experienceResponse.companyLogo).thenReturn("companyLogo $i")
                Mockito.`when`(experienceResponse.roleName).thenReturn("roleName $i")
                Mockito.`when`(experienceResponse.startDate).thenReturn("startDate $i")
                Mockito.`when`(experienceResponse.endDate).thenReturn("endDate $i")
                experiences.add(experienceResponse)
            }

            val cvResponse = Mockito.mock(CVResponse::class.java)

            Mockito.`when`(cvResponse.skills).thenReturn(skills)
            Mockito.`when`(cvResponse.experiences).thenReturn(experiences)

            Mockito.`when`(cvResponse.name).thenReturn("Jon Snow")
            Mockito.`when`(cvResponse.summery).thenReturn("He knows nothing")

            return cvResponse
        }
    }
}