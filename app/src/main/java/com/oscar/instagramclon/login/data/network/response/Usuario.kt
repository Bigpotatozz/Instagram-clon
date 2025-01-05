package com.oscar.instagramclon.login.data.network.response

data class Usuario( val usuario: Int,
val nombre:String,
val correo:String,
val contrasenia: String,
val rol: String,
val estatus: Boolean ){

}
