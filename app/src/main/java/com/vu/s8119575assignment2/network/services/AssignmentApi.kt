package com.vu.s8119575assignment2.network.services

import com.vu.s8119575assignment2.network.data.login.LoginRequest
import com.vu.s8119575assignment2.network.data.login.LoginResponse
import com.vu.s8119575assignment2.network.data.dashboard.DashboardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AssignmentApi {
    @POST("footscray/auth")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(@Path("keypass") keypass: String): Response<DashboardResponse>
}