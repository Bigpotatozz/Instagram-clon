package com.oscar.instagramclon.login.ui

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oscar.instagramclon.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier, loginViewModel: LoginViewModel){

    Box(modifier.fillMaxSize().padding(8.dp)){
        Header(Modifier.align(Alignment.TopEnd));
        Body(Modifier.align(Alignment.Center), loginViewModel)
        Footer(Modifier.align(Alignment.BottomEnd))

    }
}

@Composable
fun Header(modifier: Modifier){
    val activity = LocalContext.current as Activity;
    Column (modifier){
        Icon(imageVector = Icons.Filled.Close,
            contentDescription = "Instagram",
            modifier = Modifier.clickable { activity.finish() })
    }
}

//INICIO DE SESION
@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel){
    //SUCRIBIRSE AL VIEWMODEL
    val correo: String by loginViewModel.email.observeAsState(initial = "");
    val password: String by loginViewModel.password.observeAsState(initial = "");
    val validacionLogin: Boolean by loginViewModel.loginEnabled.observeAsState(initial = false);

    Column(modifier){

        Image(painter = painterResource(id = R.drawable.insta),
            contentDescription = "Instagram",
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth())
        Email(correo = correo, onValueChange = {
            loginViewModel.onLoginChanged(it, password);
        })
        Spacer(Modifier.size(4.dp))
        Password(password = password, onValueChange = {
            loginViewModel.onLoginChanged(correo, it);
        })
        Spacer(Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        LogInButton(modifier, loginValidation = validacionLogin){
            println(correo)
            println(password)
        };
        Spacer(Modifier.size(8.dp))
        LoginDivider()
        FacebookLogin(Modifier.align(Alignment.CenterHorizontally));

    }
}

@Composable
fun Email(correo: String, onValueChange: (String) -> Unit){
        OutlinedTextField(value = correo, onValueChange = {onValueChange(it)}, label = {
            Text("Email")
        },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )
}

@Composable
fun Password(password: String, onValueChange: (String) -> Unit){

    var visible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(value = password, onValueChange = {onValueChange(it)}, label = {
        Text("Password")
    },
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if(visible){
                Icons.Filled.VisibilityOff
            }else{
                Icons.Filled.Visibility
            }

            IconButton(onClick = {visible = !visible}) {
                Icon(imagen, contentDescription = "mostrar/ocultar")
            }
        },
        visualTransformation = if(visible)
        {VisualTransformation.None}
        else
        {PasswordVisualTransformation()})

}

@Composable
fun ForgotPassword(modifier: Modifier){

    Text("Forgot password?",
        color = Color(0xFF4EA8E9),
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier)
}

@Composable
fun LogInButton(modifier: Modifier,  loginValidation: Boolean, onClick: () -> Unit ){

    OutlinedButton(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, Color.Transparent),
        enabled = loginValidation,
        colors = ButtonColors(
            contentColor = Color.White, containerColor = Color(0xFF4EA8E9),
            disabledContentColor = Color.White, disabledContainerColor = Color.Gray),
        onClick = {
            onClick()
        }) {
        Text("Log In")
    }

}

@Composable
fun LoginDivider(){
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(Modifier.background(Color.Black).height(1.dp).weight(1f))
        Text("OR", Modifier.padding(6.dp), fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFB5B5B5))
        HorizontalDivider(Modifier.background(Color.Black).height(1.dp).weight(1f))
    }
}

@Composable
fun FacebookLogin(modifier: Modifier){

    TextButton(onClick = {}, modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook",
                Modifier.size(20.dp))
            Spacer(Modifier.size(5.dp))
            Text("Continue with facebook", fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black)
        }
    }

}

//EMPIEZA FOOTER
@Composable
fun Footer(modifier: Modifier){

    Column(modifier.padding(bottom = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalDivider(Modifier.background(Color.Black).height(1.dp));
        Row (verticalAlignment = Alignment.CenterVertically){
            Text("Don't have an account?",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(end = 6.dp))
            Text("Sign Up",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4EA8E9))

        }

    }
}

