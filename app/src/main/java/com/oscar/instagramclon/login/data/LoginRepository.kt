package com.oscar.instagramclon.login.data.network

import com.oscar.instagramclon.login.data.network.response.LoginService

class LoginRepository {

    private val api = LoginService();

    suspend fun doLogin(): Boolean{
        return api.doLogin()
    }
}