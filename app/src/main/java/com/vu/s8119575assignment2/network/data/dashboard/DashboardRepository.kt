package com.vu.s8119575assignment2.network.data.dashboard

import com.vu.s8119575assignment2.network.services.AssignmentApi
import jakarta.inject.Inject
import retrofit2.Response

class DashboardRepository @Inject constructor (val assignmentService: AssignmentApi) {

    suspend fun getDashboard(keypass: String): Response<DashboardResponse> {
        return assignmentService.getDashboard(keypass)
    }
}