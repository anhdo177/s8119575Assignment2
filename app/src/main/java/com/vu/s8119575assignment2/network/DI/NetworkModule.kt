package com.vu.s8119575assignment2.network.DI

import com.vu.s8119575assignment2.network.services.AssignmentApi
import com.vu.s8119575assignment2.network.utilities.RetrofitUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun createRetrofit(): Retrofit = RetrofitUtility.createRetrofit("https://nit3213apinew.onrender.com/")

    @Provides
    fun provideAssigmentApi(retrofit: Retrofit) = retrofit.create(AssignmentApi::class.java)

}