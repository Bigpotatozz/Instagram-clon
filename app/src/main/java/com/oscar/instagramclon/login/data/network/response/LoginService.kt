package com.oscar.instagramclon.login.data.network.response

import com.oscar.instagramclon.login.data.network.LoginClient
import com.oscar.instagramclon.login.data.network.request.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class LoginService @Inject constructor(private val loginClient: LoginClient){

    suspend fun doLogin(): LoginResponse{
        try{
           val response = withContext(Dispatchers.IO){
               loginClient.loginFake();
            }

            if(response.isSuccessful){
                return response.body()!!;
            }else{

                throw HttpException(response);

            }
        }catch (error: Exception){
            print(error.message)
            throw error;
        }
    }


    suspend fun doLoginReal(user: String, password: String): LoginResponse{


        try{

            var loginRequest: LoginRequest = LoginRequest(user, password);

            val response = withContext(Dispatchers.IO){
                 loginClient.login(loginRequest);
            }

            if(response.isSuccessful){
                return LoginResponse.Success(LoginResult(response.message(), response.body()!!.usuario))
            }else{
                return LoginResponse.Error(ErrorResponse(response.message(), false));
            }


        }catch (error: HttpException){
            print(error);
            return LoginResponse.Error(ErrorResponse(error.message(), false));
        }

    }


}