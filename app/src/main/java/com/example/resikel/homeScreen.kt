package com.example.resikel

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.resikel.auth.AuthState
import com.example.resikel.auth.AuthViewModel
import com.example.resikel.ui.theme.montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {

    val username by authViewModel.username.observeAsState("")
    val interactionSource = remember { MutableInteractionSource() }
    val scrollState = rememberScrollState()
    val items = listOf(
        Pair("Gopay", R.drawable.ic_gopay),
        Pair("Shopeepay", R.drawable.ic_shopeepay),
        Pair("Ovo", R.drawable.ic_ovo)
    )


    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(Color(252, 255, 252))
    ) {
        Box {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp), // Sesuaikan tinggi
                color = colorResource(R.color.main_green),
                shadowElevation = 4.dp
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Baris pertama (judul dan navigasi)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.ic_logohome),
                                "",
                                modifier = Modifier.size(165.dp)
                            )
                        }


                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.maskot_rakun),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clickable { navController.navigate("chatScreen") }
                            )

                            Image(
                                painter = painterResource(R.drawable.ic_notif),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(25.dp)
                                    .clickable { navController.navigate("notifScreen") }
                            )
                        }
                    }
                }
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
                                painter = painterResource(R.drawable.user_default),
                                contentDescription = "nahidul",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color(64, 64, 64), CircleShape),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "$username",
                                    fontFamily = montserrat,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(
                                    "20.000 Poin",
                                    fontFamily = montserrat,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            border = BorderStroke(1.dp, Color(64, 64, 64)),
                            onClick = { navController.navigate("onProggress") }
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
//        fitur
        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clickable { navController.navigate("MyCommunity") }
                        .height(130.dp)
                        .width(160.dp)
                        .background(
                            Color(67, 110, 255).copy(alpha = 0.09f),
                            shape = RoundedCornerShape(25.dp)
                        ),

                    Alignment.CenterStart
                ) {
                    Column(Modifier.padding(10.dp)) {
                        Surface(
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
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.bg_fiturcomu),
                        "",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Box(
                    modifier = Modifier
                        .clickable { navController.navigate("locationScreen") }
                        .height(130.dp)
                        .width(160.dp)
                        .background(
                            Color(29, 205, 158).copy(alpha = 0.09f),
                            shape = RoundedCornerShape(25.dp)
                        ),
                    Alignment.CenterStart
                ) {
                    Column(
                        Modifier.padding(10.dp)
                    ) {
                        Surface(
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
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.bg_fiturlocation),
                        "",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .height(130.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) { navController.navigate("reportScreen") }
                        .width(160.dp)
                        .background(
                            Color(255, 104, 81).copy(alpha = 0.09f),
                            shape = RoundedCornerShape(25.dp)
                        ),

                    Alignment.CenterStart
                ) {
                    Column(Modifier.padding(10.dp)) {
                        Surface(
                            modifier = Modifier.size(65.dp),
                            shape = RoundedCornerShape(33.dp),
                            color = Color(243, 243, 243),
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_report),
                                contentDescription = "",
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "Report",
                            fontFamily = montserrat,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.bg_fiturreport),
                        "",
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Box(
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) { navController.navigate("pickupScreen") }
                        .height(130.dp)
                        .width(160.dp)
                        .background(
                            Color(252, 175, 43).copy(alpha = 0.09f),
                            shape = RoundedCornerShape(25.dp)
                        ),

                    Alignment.CenterStart
                ) {
                    Column(Modifier.padding(10.dp)) {
                        Surface(
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
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.bg_fiturpickup),
                        "",
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }
        }


//information
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
            color = colorResource(R.color.white),
            shape = RoundedCornerShape(6.dp),
            shadowElevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("detailInformasi") }
                .padding(start = 20.dp, bottom = 10.dp, end = 20.dp, top = 0.dp)
                .height(200.dp)
        ) {
            Column() {
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
    homeScreen(navController = rememberNavController(), authViewModel = AuthViewModel())
}

