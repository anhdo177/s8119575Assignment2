package com.vu.s8119575assignment2.ui.dashboard

import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import com.vu.s8119575assignment2.network.data.dashboard.DashboardRepository
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.vu.s8119575assignment2.network.data.dashboard.Entity
import java.io.IOException

@HiltViewModel
class DashboardViewModel @Inject constructor (private val dashboardRepository: DashboardRepository): ViewModel() {

    private val entitiesFlow = MutableStateFlow<List<Entity>>(listOf())
    val entities: StateFlow<List<Entity>> = entitiesFlow

    private val errorMessageFlow = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = errorMessageFlow

    suspend fun getDashboardData(keypass: String) {
        errorMessageFlow.value = null

        try {
            val response = dashboardRepository.getDashboard(keypass)

            if (response.isSuccessful) {
                val result = response.body()

                if (result != null) {
                    entitiesFlow.value = result.entities
                }
            } else errorMessageFlow.value = "Unable to load dashboard data."
        } catch (exception: IOException) {
            errorMessageFlow.value = "Unable to connect. Check your internet and try again."

        }
    }
}