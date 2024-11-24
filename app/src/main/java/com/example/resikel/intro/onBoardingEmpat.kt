package com.example.resikel.intro

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
fun onBoardingEmpat(modifier: Modifier = Modifier, navController: NavController) {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(R.drawable.image_boardingempat),
                "", contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = 250.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    "Come Join\n" +
                            "With Us",
                    color = colorResource(R.color.main_green),
                    fontFamily = montserrat,
                    lineHeight = 42.sp,
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    "Become someone who cares about" +
                            "\nwaste management and cares about" +
                            "\nthe future",
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontFamily = montserrat,
                    color = colorResource(R.color.main_green)

                )
                Spacer(Modifier.height(40.dp))
                Button(
                    shape = RoundedCornerShape(10.dp),
                    onClick = { navController.navigate("welcome_resikel") },
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                        .padding(start = 45.dp, end = 45.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.main_green),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Let’s Get Started",
                        fontSize = 25.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

    }
}

@Preview
@Composable
private fun preonBoardingEmpat() {
    onBoardingEmpat(navController = rememberNavController())
}