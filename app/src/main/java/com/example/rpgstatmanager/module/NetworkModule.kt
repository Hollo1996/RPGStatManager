package com.example.rpgstatmanager.module

import com.example.rpgstatmanager.swagger.client.apis.DataApi
import com.example.rpgstatmanager.swagger.client.apis.TokenApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideDataApi() = DataApi()

    @Provides
    @Singleton
    fun provideTokenApi() = TokenApi()
}