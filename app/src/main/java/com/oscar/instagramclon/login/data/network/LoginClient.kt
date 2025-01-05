package com.oscar.instagramclon.login.data.network

import com.oscar.instagramclon.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginClient {
    @POST("/auth/login/")
    suspend fun login(correo: String, password: String): Response<LoginResponse>

    @GET("auth/loginAndroid")
    suspend fun loginFake(): Response<LoginResponse>

}