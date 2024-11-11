package com.example.resikel

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.resikel.ui.theme.montserrat

@Composable
fun homeScreen(modifier: Modifier = Modifier, navController: NavController) {
    val scrollState = rememberScrollState()
    val items = listOf("Gopay", "shopeepay", "Ovo", "dana", "Item 5")

    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(Color(252, 255, 252))
    ) {
        Box {
            Row(

                horizontalArrangement = Arrangement.spacedBy(176.dp),
                modifier = Modifier
                    .background(Color(27, 94, 60))
                    .fillMaxWidth().padding(top = 10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_logohome),
                    contentDescription = "",

                    modifier = Modifier
                        .size(175.dp)
                        .offset(y = -30.dp)

                )
                Image(
                    painter = painterResource(R.drawable.ic_notif),
                    contentDescription = "", modifier = Modifier
                        .size(25.dp)
                        .offset(y = 35.dp)
                )
            }

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(251, 255, 249),
                shadowElevation = 10.dp,
                tonalElevation = 40.dp,
                modifier = Modifier
                    .padding(top = 95.dp)
                    .height(250.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .padding(
                                top = 20.dp,
                                start = 0.dp,
                                end = 0.dp,
                                bottom = 15.dp
                            )
                            .fillMaxWidth()
                    ) {
                        Row {
                            Image(
                                painter = painterResource(R.drawable.pp),
                                contentDescription = "nahidul",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color(64, 64, 64), CircleShape),
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(6.dp)
                            ) {
                                Text(
                                    "Naya Rafeza",
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.height(2.dp))
                                Text(
                                    "20.000 Poin",
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            border = BorderStroke(1.dp, Color(64, 64, 64)),
                            onClick = {}
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_refresh),
                                contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(Modifier.width(7.dp))
                            Text(
                                "Tukar Poin",
                                color = Color(64, 64, 64),
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                fontFamily = montserrat
                            )
                        }
                    }
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color(251, 255, 249),
                        tonalElevation = 40.dp,
                        border = BorderStroke(1.dp, color = Color.Black),
                        modifier = Modifier
                            .height(135.dp)
                            .padding(start = 30.dp, end = 30.dp, bottom = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Surface(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(135.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.bg_card),
                                    contentDescription = "", contentScale = ContentScale.FillBounds
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("20,90 TON", fontSize = 35.sp, fontWeight = FontWeight.Bold)
                                Text("Waste successfully recycled!", fontSize = 12.sp)
                            }


                        }
                    }
                }


            }
        }


        Text(
            text = "What do you want to do today?",
            modifier = Modifier.padding(start = 15.dp, top = 20.dp, bottom = 15.dp, end = 15.dp),
            fontFamily = montserrat,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    onClick = {},
                    modifier = Modifier.size(65.dp),
                    shape = RoundedCornerShape(33.dp),
                    color = Color(243, 243, 243),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_com),
                        contentDescription = "",
                        modifier = Modifier.padding(15.dp)
                    )

                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Community",
                    fontFamily = montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    onClick = {},
                    modifier = Modifier.size(65.dp),
                    shape = RoundedCornerShape(33.dp),
                    color = Color(243, 243, 243),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_location),
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Location",
                    fontFamily = montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    onClick = {
                        navController.navigate("reportScreen")
                    },
                    modifier = Modifier.size(65.dp),
                    shape = RoundedCornerShape(33.dp),
                    color = Color(243, 243, 243),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_kamera),
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Report",
                    fontFamily = montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    onClick = {},
                    modifier = Modifier.size(65.dp),
                    shape = RoundedCornerShape(33.dp),
                    color = Color(243, 243, 243),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_pickup),
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Pick Up",
                    fontFamily = montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Transfer", modifier = Modifier.padding(15.dp),
            fontFamily = montserrat,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(), // Mengisi lebar layar
            horizontalArrangement = Arrangement.spacedBy(10.dp), // Memberikan jarak antar item
            contentPadding = PaddingValues(horizontal = 16.dp) // Padding di awal dan akhir
        ) {
            items(items) { item ->
                // Setiap item di dalam LazyRow
                Surface(
                    shadowElevation = 12.dp,
                    shape = RoundedCornerShape(5.dp),
                    color = Color.Gray,
                    modifier = Modifier
                        .size(110.dp)
                        .padding(5.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
                        Spacer(Modifier.height(10.dp))
                        Text(text = item, color = Color.White)
                    }

                }
            }
        }
        Spacer(Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Today's Information", modifier = Modifier.padding(15.dp),
                fontFamily = montserrat,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "See more", modifier = Modifier.padding(15.dp),
                fontFamily = montserrat,
                fontSize = 14.sp,
                color = Color(27, 94, 60),
                fontWeight = FontWeight.Bold
            )
        }
        Surface(
            color = Color.Gray,
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom = 10.dp, end = 20.dp, top = 0.dp)
                .height(200.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.contethome),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse non metus a ipsum fermentum fermentum vel et ligula. Mauris mattis, nulla eget tempus porta, sem augue iaculis ante, vel tristique orci ante a eros.",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
        Surface(
            color = Color.Gray,
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .height(200.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.contethome),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse non metus a ipsum fermentum fermentum vel et ligula. Mauris mattis, nulla eget tempus porta, sem augue iaculis ante, vel tristique orci ante a eros.",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

    }
}

@Preview
@Composable
private fun prehomescreen() {
    homeScreen(navController = rememberNavController())
}

