package com.example.resikel.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.resikel.R
import com.example.resikel.ui.theme.montserrat

@Composable
fun welcomeResikel(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.height(
                530.dp,
            )
        ) {
            Image(
                painter = painterResource(R.drawable.bg),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(R.drawable.bgcolor),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "Peduli sampah, jangan nyampah,\n dan mulutmu jangan bau sampah,\n paham",
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            color = Color(27, 94, 60),
            fontFamily = montserrat,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(27, 94, 60)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 18.dp, start = 22.dp, end = 22.dp, bottom = 2.dp),
            onClick = { navController.navigate("sign_in") }) {
            Text(
                text = "Sign In",
                fontFamily = montserrat,
                fontSize = 22.sp,
            )
        }

        Button(
            border = BorderStroke(3.dp, color = Color(27, 94, 60)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 12.dp),
            onClick = {navController.navigate("sign_up")}) {
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Normal,
                color = Color(27, 94, 60),
                fontFamily = montserrat,
                fontSize = 22.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "By logging in or registering, you agree to our",
            fontSize = 10.sp,
            color = Color(27, 94, 60),
            fontWeight = FontWeight.Normal,
            fontFamily = montserrat
        )
        Row {
            Text(
                text = "Terms of Service", fontSize = 10.sp,
                color = Color(27, 94, 60),
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
            Text(
                text = " and ", fontSize = 10.sp,
                color = Color(27, 94, 60),
                fontWeight = FontWeight.Normal,
                fontFamily = montserrat
            )
            Text(
                text = "Privacy Policy", fontSize = 10.sp,
                color = Color(27, 94, 60),
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
        }

    }
}

@Preview
@Composable
private fun precwelcom() {
    welcomeResikel(navController = rememberNavController())
}

