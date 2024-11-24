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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
fun onBoardingDua(modifier: Modifier = Modifier,navController: NavController) {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(R.drawable.image_boardingdua),
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
                    "Everything Can\n" +
                            "Be Recycled",
                    color = colorResource(R.color.main_green),
                    fontFamily = montserrat,
                    lineHeight = 42.sp,
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    "By recycling, you help preserve the" +
                            "\n earth and the welfare of society",
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontFamily = montserrat,
                    color = colorResource(R.color.main_green)

                )
                Spacer(Modifier.height(60.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(Modifier.width(12.dp))
                    Button(
                        border = BorderStroke(1.dp, Color(161,164,178)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(10.dp),
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .height(64.dp)
                            .width(140.dp)
                    ) {
                        Text(
                            text = "Back",
                            fontSize = 25.sp,
                            color = Color(161,164,178),
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        shape = RoundedCornerShape(10.dp),
                        onClick = { navController.navigate("onBoardingTiga")},
                        modifier = Modifier
                            .height(64.dp)
                            .width(140.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.main_green),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Next",
                            fontSize = 25.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                }


            }
        }

    }

}

@Preview
@Composable
private fun preonBoardingDua() {
    onBoardingDua(navController = rememberNavController())
}