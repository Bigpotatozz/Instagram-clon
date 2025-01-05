package com.oscar.instagramclon.login.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse( @SerializedName("message")val message: String,
                          @SerializedName("estatus") val estatus: Boolean){}
