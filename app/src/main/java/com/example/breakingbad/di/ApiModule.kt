package com.example.breakingbad.di

import com.example.breakingbad.data.api.ApiRepositoryImpl
import com.example.breakingbad.data.api.ApiRequests
import com.example.breakingbad.data.api.utils.RequestURL.BASE_URL
import com.example.breakingbad.domain.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {


    @Provides
    @Singleton
    fun provideApiRepository(apiRequests: ApiRequests):ApiRepository{
        return ApiRepositoryImpl(api = apiRequests)
    }


    @Provides
    @Singleton
    fun provideApiRequests():ApiRequests{
        val connect = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiRequests::class.java)
        return connect
    }


}