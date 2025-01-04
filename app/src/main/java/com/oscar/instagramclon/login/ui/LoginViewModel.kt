package com.oscar.instagramclon.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val _email = MutableLiveData<String>();
    var email: LiveData<String> = _email;
    private val _password = MutableLiveData<String>();
    var password: LiveData<String> = _password;

    private val _loginEnabled = MutableLiveData<Boolean>();
    var loginEnabled: LiveData<Boolean> = _loginEnabled;

    fun onLoginChanged(email:String, password: String){
        _email.value = email;
        _password.value = password
       _loginEnabled.value = enableLoginButton(email, password)
    }

    //VALIDACIONES DE LOS INPUTS
    fun enableLoginButton(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
    }


}