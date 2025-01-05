package com.oscar.instagramclon.login.domain

import com.oscar.instagramclon.login.data.network.LoginRepository
import com.oscar.instagramclon.login.data.network.response.LoginResponse

class LoginUseCase {

    private val loginRepository = LoginRepository();

    suspend fun loginInvoke(): LoginResponse{
        return loginRepository.doLogin();
    }

    suspend fun loginRealInovoke(user: String, password: String): LoginResponse{
        return loginRepository.realLogin(user, password);
    }

}