package com.vu.s8119575assignment2.ui.login

import com.vu.s8119575assignment2.network.data.login.LoginRepository
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.vu.s8119575assignment2.ui.LoginViewModel
import com.vu.s8119575assignment2.network.data.login.LoginResponse
import io.mockk.coEvery
import retrofit2.Response

class LoginViewModelTest {
    private lateinit var viewModel: LoginViewModel
    private lateinit var loginRepository: LoginRepository

    @Before
    fun setup() {
        loginRepository = mockk()
        viewModel = LoginViewModel(loginRepository)
    }

    @Test
    fun emptyInputShowsValidationError() = runTest {
        viewModel.login ("", "")
        assertEquals ( "Please enter your student ID and password.",
            viewModel.errorMessage.value
        )
    }

    @Test
    fun successfulLoginUpdatesKeypass() = runTest {
        coEvery {
            loginRepository.login("1234567","Annie")
        } returns Response.success(LoginResponse("technology"))

        viewModel.login("1234567", "Annie")

        assertEquals(
            "technology",
            viewModel.keypass.value )
    }

    @Test
    fun failedLoginShowsErrorMessage() = runTest {
        coEvery {
            loginRepository.login("12345678", "WrongName")
        } returns Response.error(401, okhttp3.ResponseBody.create(null, ""))

        viewModel.login("12345678", "WrongName")

        assertEquals (
            "Login failed. Check your details and try again.",
            viewModel.errorMessage.value
        )
    }
}