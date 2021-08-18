package com.example.harrypotter.di

import com.example.harrypotter.data.remote.PotterService
import com.example.harrypotter.utils.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun giveMeGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun giveMeRetrofit(gson:Gson):Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun giveMeNetworkService(retrofit: Retrofit.Builder):PotterService{
        return retrofit.build()
            .create(PotterService::class.java)
    }

}