package com.example.resikel.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun editProfile(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(252, 255, 252))
            .height(280.dp)
    ) {


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 30.dp)
        )
        {
            IconButton(
                onClick = {
//                    tombol ke halaman sebelumnya
                    navController.popBackStack()
                }) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    Modifier.size(30.dp)
                )
            }
            Text(
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

        Surface(
            shadowElevation = 12.dp,
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(580.dp)
                .offset(x = 0.dp, y = 120.dp)
                .padding(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .offset(y = 160.dp),

                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Personal Info",
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(10.dp))
//                phone no
                Row(
                    Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_call),
                        contentDescription = "nahidul",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color(64, 64, 64), CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        Text(
                            "Phone No.",
                            color = Color(134, 136, 137),
                            fontFamily = montserrat,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "08231765456",
                            fontSize = 14.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
//                date of birthd
                Row(
                    Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_date),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color(64, 64, 64), CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        Text(
                            "Date of Birthd",
                            color = Color(134, 136, 137),
                            fontFamily = montserrat,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "12 Desember 2004",
                            fontSize = 14.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
//                address
                Row(
                    Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_address),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color(64, 64, 64), CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        Text(
                            "Address",
                            color = Color(134, 136, 137),
                            fontFamily = montserrat,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "Jl. Sudirman 123, Kecamatan \n" +
                                    "Cibunglang, Desa Cibatok",
                            fontSize = 14.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(Modifier.height(35.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(27,94,60)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                        .padding( start = 12.dp, end = 12.dp),
                    onClick = {}) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            tint = Color.Unspecified,
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.ic_edit), // Replace with your icon resource
                            contentDescription = "Button Icon",
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = "Edit Profile",
                            fontWeight = FontWeight.Bold,
                            fontFamily = montserrat,
                            fontSize = 20.sp,
                        )
                    }

                }
            }
        }

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(Modifier.height(90.dp))
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
                text = "Naya Rafeza",
                color = Color(27,94,60),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
            Text(
                text = "NayaRafeza@gmail.com",
                color = Color(27,94,60),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat
            )
        }

    }

}

@Preview
@Composable
private fun preeditProfile() {
    editProfile(navController = rememberNavController())
}