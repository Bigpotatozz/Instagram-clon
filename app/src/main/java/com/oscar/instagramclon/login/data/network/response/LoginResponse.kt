package com.oscar.instagramclon.login.data.network.response

sealed class LoginResponse {

    data class Success(val loginResult: LoginResult): LoginResponse();
    data class Error(val errorResponse: ErrorResponse): LoginResponse();
}