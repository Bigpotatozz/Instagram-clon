package com.oscar.instagramclon.login.domain

import com.oscar.instagramclon.login.data.network.LoginRepository

class LoginUseCase {

    private val loginRepository = LoginRepository();

    suspend fun loginInvoke(): Boolean{
        return loginRepository.doLogin();
    }

}