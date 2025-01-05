package com.oscar.instagramclon.login.data.network.response

import com.oscar.instagramclon.core.network.RetrofitHelper
import com.oscar.instagramclon.login.data.network.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {

   private val retrofit = RetrofitHelper.getRetrofit();

    suspend fun doLogin(): Boolean{
       return withContext(Dispatchers.IO){
            val response = retrofit.create(LoginClient::class.java).loginFake()
           response.body()?.estatus ?: false


        }

    }


}