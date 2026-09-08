package com.vu.s8119575assignment2.network.data

import com.vu.s8119575assignment2.network.services.AssignmentApi
import jakarta.inject.Inject
import retrofit2.Response

class LoginRepository @Inject constructor (val assignmentService: AssignmentApi) {

    suspend fun login(
        username: String,
        password: String
    ): Response<LoginResponse> {
        val request = LoginRequest(
            username = username,
            password = password
        )

        return assignmentService.login(request)
    }
}