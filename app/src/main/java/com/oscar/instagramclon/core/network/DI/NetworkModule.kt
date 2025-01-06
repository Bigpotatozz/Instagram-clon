package com.oscar.instagramclon.core.network.DI

import com.oscar.instagramclon.login.data.network.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun retrofitHelper(): Retrofit{
       return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8081/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginClient(retrofit: Retrofit): LoginClient{

        return retrofit.create(LoginClient::class.java);
    }
}