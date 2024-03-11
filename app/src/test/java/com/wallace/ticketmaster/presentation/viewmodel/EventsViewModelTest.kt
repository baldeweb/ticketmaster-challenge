package com.wallace.ticketmaster.presentation.viewmodel

import com.wallace.ticketmaster.domain.dto.BaseResponse
import com.wallace.ticketmaster.domain.dto.EventModel
import com.wallace.ticketmaster.domain.dto.EventsModel
import com.wallace.ticketmaster.domain.usecase.EventsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class EventsViewModelTest {

    private lateinit var viewModel: EventsViewModel
    private val eventsUseCase: EventsUseCase = mockk()
    private val sampleEvent = EventModel(name = "Event Happy", id = "1")

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)

        viewModel = EventsViewModel(eventsUseCase, Dispatchers.Unconfined)
    }

    @Test
    fun `GIVEN getEvents is called, WHEN isLoading should be updated correctly THEN events should be updated`() {
        //  GIVEN
        val eventsModel = EventsModel(arrayListOf(sampleEvent))
        coEvery { eventsUseCase.execute() } returns Response.success(BaseResponse(eventsModel))

        //  WHEN
        viewModel.getEvents()

        //  THEN
        assertFalse(viewModel.isLoading.value)
        assertTrue(viewModel.eventsStateFlow.value.isNotEmpty())
        assertTrue(viewModel.eventsStateFlow.value.contains(sampleEvent))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
