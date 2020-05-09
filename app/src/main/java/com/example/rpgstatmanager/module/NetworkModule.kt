package com.example.rpgstatmanager.module

import com.example.rpgstatmanager.swagger.client.api.DataApi
import com.example.rpgstatmanager.swagger.client.api.TokenApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideDataApi(client: OkHttpClient): DataApi{
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("rpgmanager.data.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(DataApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTokenApi(client: OkHttpClient): TokenApi{
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("rpgmanager.data.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(TokenApi::class.java)
    }
}