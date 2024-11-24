package com.example.resikel.auth

import android.annotation.SuppressLint
import android.os.Build
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.resikel.R
import com.example.resikel.pickup.CourierArrivedBody
import com.example.resikel.pickup.buttonNext
import com.example.resikel.ui.theme.montserrat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun forGotPassword(modifier: Modifier = Modifier,navController: NavController) {
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    activity?.window?.let { window ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val insetsController = window.insetsController
            insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = Color.Transparent.toArgb()
        }
    }
    Scaffold(
        topBar = { appbarReset(navController = navController) },
        bottomBar = { buttonResetPass() },
        contentWindowInsets = WindowInsets.systemBars,
    ) {
        contentResetPassword()
    }
}

@Composable
fun buttonResetPass(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(35.dp)
        .clickable { }
        .wrapContentHeight()) {
        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.main_green),
                    shape = RoundedCornerShape(36.dp)
                )
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Reset Password",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = montserrat,
                style = TextStyle(fontWeight = FontWeight.ExtraBold),
                fontSize = 16.sp,
                color = colorResource(id = R.color.white),
            )
        }
    }
}

@Composable
fun contentResetPassword(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.height(90.dp))
        Image(
            painter = painterResource(R.drawable.bg_forgotpassword),
            "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp, top = 50.dp, bottom = 30.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(
                text = "Password recovery",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "A password recovery link will be sent\n" +
                        "via your email.", fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = montserrat
            )
            Spacer(Modifier.height(25.dp))
            Text(
                text = "Email",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
            Spacer(Modifier.height(15.dp))
            TextField(
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_email),
                        "",
                        modifier = Modifier.size(25.dp)
                    )
                },
                placeholder = { Text("email123@gmail.com",  color = Color.Gray) },
                value = name,
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(242, 243, 247),
                    unfocusedContainerColor = Color(242, 243, 247),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun appbarReset(modifier: Modifier = Modifier,navController: NavController) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(56.dp)
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .background(
                    color = colorResource(R.color.main_green),
                    shape = RoundedCornerShape(36.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
navController.popBackStack()
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrowleft),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = colorResource(R.color.white)
            )
        }
        Text(
            text = "Forgot Password?",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 16.dp),
            fontFamily = montserrat,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = colorResource(R.color.main_green),
        )
    }
}

@Preview
@Composable
private fun preforGotPassword() {
    forGotPassword(navController = rememberNavController())
}