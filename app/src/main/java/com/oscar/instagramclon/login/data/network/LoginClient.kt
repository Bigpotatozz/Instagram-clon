package com.oscar.instagramclon.login.data.network

import com.oscar.instagramclon.login.data.network.request.LoginRequest
import com.oscar.instagramclon.login.data.network.response.LoginResponse
import com.oscar.instagramclon.login.data.network.response.LoginResult
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST




interface LoginClient {

    @POST("auth/login/")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResult>


    @GET("auth/loginAndroid")
    suspend fun loginFake(): Response<LoginResponse>

}