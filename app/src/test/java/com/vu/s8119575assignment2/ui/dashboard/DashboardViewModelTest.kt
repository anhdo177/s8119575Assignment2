package com.vu.s8119575assignment2.ui.dashboard

import com.vu.s8119575assignment2.network.data.dashboard.DashboardRepository
import com.vu.s8119575assignment2.network.data.dashboard.Entity
import com.vu.s8119575assignment2.network.data.dashboard.DashboardResponse
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import io.mockk.coEvery
import retrofit2.Response
import org.junit.Assert.assertEquals
import okhttp3.ResponseBody.Companion.toResponseBody

class DashboardViewModelTest {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var dashboardRepository: DashboardRepository

    @Before
    fun setup() {
        dashboardRepository = mockk()
        viewModel = DashboardViewModel(dashboardRepository)
    }

    @Test
    fun successfulDashboardLoadUpdatesEntities() = runTest {
        val fakeEntities = listOf(
            Entity(
                deviceName = "Smartphone",
                manufacturer = "Apple",
                operatingSystem = "iOS",
                releaseYear = 2023,
                description = "A powerful handheld device."
            )
        )

        coEvery {
            dashboardRepository.getDashboard("technology")
        } returns Response.success(DashboardResponse(entities = fakeEntities, entityTotal = 1))
        viewModel.getDashboardData("technology")

        assertEquals(
            fakeEntities,
            viewModel.entities.value
        )
    }

    @Test
    fun failedDashboardLoadShowsErrorMessage() = runTest {
        coEvery {
            dashboardRepository.getDashboard("technology")
        } returns Response.error(
            404,
            "".toResponseBody()
        )

        viewModel.getDashboardData("technology")

        assertEquals(
            "Unable to load dashboard data.",
            viewModel.errorMessage.value
        )
    }
}