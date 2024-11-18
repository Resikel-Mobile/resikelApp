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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun editProfile(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val textState = remember { mutableStateOf("Miloenakk") }
    val emailState = remember { mutableStateOf("miloenakofficial@gmail.com") }
    val phoneState = remember { mutableStateOf("081627389292") }
    val dateState = remember { mutableStateOf("29 Juni 2004") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(252, 255, 252))
    ) {
        Box(
        ) {
            Image(
                painter = painterResource(R.drawable.bg_profilescreen),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(235.dp)
                    .fillMaxWidth()
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 35.dp)
            )
            {
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White),
                    onClick = {
                        navController.popBackStack()
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
                    fontSize = 32.sp,
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
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .offset(x = 0.dp, y = 150.dp)
                    .padding(20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 60.dp),
                    horizontalAlignment = Alignment.Start
                ) {
//                Edit profile
                    Column(modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 10.dp, end = 25.dp)
                    ) {
                        // Label di atas
                        Text(
                            text = "Username",
                            fontSize = 10.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                        // TextField tanpa Outline, hanya garis bawah
                        TextField(
                            value = textState.value,
                            onValueChange = { textState.value = it },
                            trailingIcon = {
                                    Image(
                                        painter = painterResource(R.drawable.ic_input), // Ikon pertama
                                        contentDescription = "Copy",
                                        modifier = Modifier.size(20.dp)
                                    )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent, // Latar belakang transparan
                                focusedIndicatorColor = Color.Black, // Garis bawah aktif
                                unfocusedIndicatorColor = Color.Gray, // Garis bawah tidak aktif

                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }

//                Email
                    Column(modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 10.dp, end = 25.dp)) {
                        // Label di atas
                        Text(
                            text = "Email",
                            fontSize = 10.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                        // TextField tanpa Outline, hanya garis bawah
                        TextField(
                            value = emailState.value,
                            onValueChange = { emailState.value = it },
                            trailingIcon = {
                                Image(
                                    painter = painterResource(R.drawable.ic_input), // Ikon pertama
                                    contentDescription = "Copy",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent, // Latar belakang transparan
                                focusedIndicatorColor = Color.Black, // Garis bawah aktif
                                unfocusedIndicatorColor = Color.Gray, // Garis bawah tidak aktif

                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
//                Phone number
                    Column(modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 10.dp, end = 25.dp)) {
                        // Label di atas
                        Text(
                            text = "Phone Number",
                            fontSize = 10.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                        // TextField tanpa Outline, hanya garis bawah
                        TextField(
                            value = phoneState.value,
                            onValueChange = { phoneState.value = it },
                            trailingIcon = {
                                Image(
                                    painter = painterResource(R.drawable.ic_input), // Ikon pertama
                                    contentDescription = "Copy",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent, // Latar belakang transparan
                                focusedIndicatorColor = Color.Black, // Garis bawah aktif
                                unfocusedIndicatorColor = Color.Gray, // Garis bawah tidak aktif

                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
//                    Birth Date
                    Column(modifier = Modifier.padding(start = 25.dp, top = 10.dp, bottom = 10.dp, end = 25.dp)
                    ) {
                        // Label di atas
                        Text(
                            text = "Birth Date",
                            fontSize = 10.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold
                        )
                        // TextField tanpa Outline, hanya garis bawah
                        TextField(
                            value = dateState.value,
                            onValueChange = { dateState.value = it },
                            trailingIcon = {
                                Image(
                                    painter = painterResource(R.drawable.ic_input), // Ikon pertama
                                    contentDescription = "Copy",
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent, // Latar belakang transparan
                                focusedIndicatorColor = Color.Black, // Garis bawah aktif
                                unfocusedIndicatorColor = Color.Gray, // Garis bawah tidak aktif

                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                    Spacer(Modifier.height(35.dp))
//                    button simpan perubahan
                    Button(
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(89,163,89)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 35.dp, end = 35.dp),
                        onClick = {}) {
                        Text(
                            text = "Simpan Perubahan",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = montserrat,
                            fontSize = 15.sp,
                        )
                    }
                    Spacer(Modifier.height(80.dp))
                }
            }

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(Modifier.height(115.dp))
                Image(
                    painter = painterResource(R.drawable.pp),
                    contentDescription = "",
                    modifier = Modifier
                        .size(115.dp)
                        .clip(CircleShape)
                        .border(6.dp, Color.White, CircleShape),
                    contentScale = ContentScale.Crop
                )

            }


        }


    }

}

@Preview
@Composable
private fun preeditProfile() {
    editProfile(navController = rememberNavController())
}