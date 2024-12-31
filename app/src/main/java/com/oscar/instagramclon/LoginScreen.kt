package com.oscar.instagramclon

import android.app.Activity
import android.graphics.Paint.Align
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LoginScreen(modifier: Modifier = Modifier){

    Box(modifier.fillMaxSize().padding(8.dp)){
        Header(Modifier.align(Alignment.TopEnd));
        Body(Modifier.align(Alignment.Center))

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
fun Body(modifier: Modifier){
    var correo by rememberSaveable { mutableStateOf("")}
    var password by rememberSaveable { mutableStateOf("")}

    Column(modifier){

        Image(painter = painterResource(id = R.drawable.insta),
            contentDescription = "Instagram",
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth())
        Email(correo = correo, onValueChange = { correo = it})
        Spacer(Modifier.size(4.dp))
        Password(password = password, onValueChange = {password = it})
        Spacer(Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        LogInButton(modifier){
            println(correo)
            println(password)
        };
    }
}

@Composable
fun Email(correo: String, onValueChange: (String) -> Unit){
        OutlinedTextField(value = correo, onValueChange = {onValueChange(it)}, label = {
            Text("Correo electronico")
        },
            modifier = Modifier.fillMaxWidth())
}

@Composable
fun Password(password: String, onValueChange: (String) -> Unit){
    OutlinedTextField(value = password, onValueChange = {onValueChange(it)}, label = {
        Text("Contraseña")
    },
        modifier = Modifier.fillMaxWidth())

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
fun LogInButton(modifier: Modifier, onClick: () -> Unit ){

    OutlinedButton(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, Color.Transparent),
        colors = ButtonColors(contentColor = Color.White, containerColor = Color(0xFF4EA8E9),
            disabledContentColor = Color.Gray, disabledContainerColor = Color.Cyan),
        onClick = {
            onClick()
        }) {
        Text("Iniciar sesion")
    }

}