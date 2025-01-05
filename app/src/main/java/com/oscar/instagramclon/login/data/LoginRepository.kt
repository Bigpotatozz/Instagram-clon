package com.oscar.instagramclon.login.data.network

import com.oscar.instagramclon.login.data.network.response.LoginResponse
import com.oscar.instagramclon.login.data.network.response.LoginService

class LoginRepository {

    private val api = LoginService();

    suspend fun doLogin(): LoginResponse{
        return api.doLogin()
    }

    suspend fun realLogin(user: String, password: String): LoginResponse{
        return api.doLoginReal(user, password);
    }
}