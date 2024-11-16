package com.example.resikel.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.resikel.R
import com.example.resikel.ui.theme.montserrat

@Composable
fun profileScreen(
    modifier: Modifier = Modifier,
navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(252, 255, 252))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.bg_profilescreen),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 30.dp)
            )
            {
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White),
                    onClick = { navController.popBackStack()
                    }
                ) {
                    Icon(
                        Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        Modifier.size(30.dp)
                    )
                }
                Text(
                    color = Color.White,
                    text = "Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(colors = IconButtonDefaults.iconButtonColors(contentColor = Color.Transparent),
                    onClick = {}) {
                    Icon(

                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(Modifier.height(60.dp))
                Image(
                    painter = painterResource(R.drawable.pp),
                    contentDescription = "",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(25.dp))
                Text(
                    color = Color.White,
                    text = "Naya Rafeza",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = montserrat
                )
            }

        }
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Account",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
            Spacer(Modifier.height(15.dp))
//            edit profile
            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier.background(Color.White).clickable { navController.navigate("editProfile") }
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(50.dp),
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = "",
                            )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            text = "Edit Profile",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = montserrat
                        )
                    }
                    Icon(
                        modifier = Modifier.padding(15.dp).size(30.dp),
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = ""
                    )
                }
            }
            Spacer(Modifier.height(15.dp))
//            reward
            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier.background(Color.White)
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(50.dp),
                            painter = painterResource(R.drawable.ic_wallet),
                            contentDescription = "",
                        )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            text = "Rewards",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = montserrat
                        )
                    }
                    Icon(
                        modifier = Modifier.padding(15.dp).size(30.dp),
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = ""
                    )
                }
            }
            Spacer(Modifier.height(15.dp))
//            reward
            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier.background(Color.White)
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(50.dp),
                            painter = painterResource(R.drawable.ic_logout),
                            contentDescription = "",
                        )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            text = "Log Out",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = montserrat
                        )
                    }
                    Icon(
                        modifier = Modifier.padding(15.dp).size(30.dp),
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "",
                    )
                }
            }
        }

    }
}

@Preview
@Composable
private fun preprofileSceen() {
    profileScreen(navController = rememberNavController())
}