package com.vu.s8119575assignment2.network.services

import com.vu.s8119575assignment2.network.data.LoginRequest
import com.vu.s8119575assignment2.network.data.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AssignmentApi {
    @POST("footscray/auth")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>
}