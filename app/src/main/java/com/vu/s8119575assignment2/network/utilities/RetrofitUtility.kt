package com.vu.s8119575assignment2.network.utilities

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitUtility {

    companion object {

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun createRetrofit(baseurl: String) =  Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}