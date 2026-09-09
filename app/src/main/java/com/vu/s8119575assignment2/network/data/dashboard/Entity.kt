package com.vu.s8119575assignment2.network.data.dashboard

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Entity(
    val deviceName: String,
    val manufacturer: String,
    val operatingSystem: String,
    val releaseYear: Int,
    val description: String
): Parcelable

