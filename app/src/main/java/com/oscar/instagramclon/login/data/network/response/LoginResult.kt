package com.oscar.instagramclon.login.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResult( @SerializedName("message")val message: String,
                          @SerializedName("usuario") val usuario: Usuario){}
