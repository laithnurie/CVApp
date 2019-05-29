package com.laithlab.cvapp.main

import com.laithlab.cvapp.TestHelper
import com.laithlab.cvapp.network.CVAPI
import com.laithlab.cvapp.network.ResponseConverter
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class CVRepoTest {

    @Mock
    lateinit var cvAPI: CVAPI

    @Mock
    lateinit var responseConverter: ResponseConverter

    lateinit var cvRepo: CVRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        cvRepo = CVRepo(cvAPI, responseConverter)
    }

    @Test
    fun handleValidResponse() {
        val mockResponse = TestHelper.getMockedResponse()
        `when`(cvAPI.getCV()).thenReturn(Single.just(mockResponse))

        val mainUIModel = mock(MainUIModel::class.java)
        `when`(mainUIModel.name).thenReturn("Jon Snow")
        `when`(mainUIModel.summery).thenReturn("he also know nothing")
        `when`(mainUIModel.experiences).thenReturn(ArrayList())
        `when`(mainUIModel.skills).thenReturn(ArrayList())

        `when`(responseConverter.getUIModelFromResponse(mockResponse)).thenReturn(mainUIModel)

        val testObserver = cvRepo.getCV().test()
        val listResult = testObserver.values()

        assertTrue(listResult.size == 1)
        val uiModel = listResult[0]
        assertTrue(uiModel is MainUIModel)
        assertEquals(uiModel.name, "Jon Snow")
        testObserver.assertComplete()
        testObserver.dispose()

    }

}