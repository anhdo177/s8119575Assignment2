package com.vu.s8119575assignment2.ui

import androidx.lifecycle.ViewModel
import com.vu.s8119575assignment2.network.data.login.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.IOException

@HiltViewModel
class LoginViewModel @Inject constructor (private val loginRepository: LoginRepository): ViewModel() {
    private val keypassFlow = MutableStateFlow<String?>(null)
    val keypass: StateFlow<String?> = keypassFlow

    private val errorMessageFlow = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = errorMessageFlow

    suspend fun login(username: String, password: String) {

        keypassFlow.value = null
        errorMessageFlow.value = null

        if (username.isBlank() || password.isBlank()) {
            errorMessageFlow.value = "Please enter your student ID and password."
        }
        try {
            val response = loginRepository.login(username, password)

            if (response.isSuccessful) {

                val receivedKeypass = response.body()?.keypass

                if (receivedKeypass.isNullOrBlank()) {

                    errorMessageFlow.value = "Invalid server response."

                } else keypassFlow.value = receivedKeypass

            } else errorMessageFlow.value = "Login failed. Check your details and try again."

        } catch (exception: IOException) {

            errorMessageFlow.value = "Unable to connect. Check your internet and try again."
        }
    }

    fun clearKeypass() {
        keypassFlow.value = null
    }
}
