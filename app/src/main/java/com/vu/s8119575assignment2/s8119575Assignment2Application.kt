package com.vu.s8119575assignment2


import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class s8119575Assignment2Application: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("s8119575", "Application class initialised: ")
    }
}
