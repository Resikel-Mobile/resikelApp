package com.example.resikel.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.resikel.R
import com.example.resikel.auth.AuthState
import com.example.resikel.auth.AuthViewModel
import com.example.resikel.ui.theme.montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun profileScreen(
    modifier: Modifier = Modifier,
    navController: NavController,authViewModel: AuthViewModel
) {
    val coroutineScope = rememberCoroutineScope()
    var isSheetOpen by remember { mutableStateOf(false) }

    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated -> navController.navigate("sign_in")
            else -> Unit
        }
    }


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
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.Transparent)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null // Tidak ada efek ripple
                        ) {
                            // Aksi ketika tombol diklik
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.KeyboardArrowLeft,
                        contentDescription = null, tint = Color.Transparent,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Text(
                    color = Color.White,
                    text = "Profile",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.Transparent)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null // Tidak ada efek ripple
                        ) {
                            // Aksi ketika tombol diklik
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.KeyboardArrowLeft,
                        contentDescription = null, tint = Color.Transparent,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Surface(
                shadowElevation = 12.dp,
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(460.dp)
                    .offset(x = 0.dp, y = 150.dp)
                    .padding(20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 110.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Spacer(Modifier.height(15.dp))
                    Image(
                        painter = painterResource(R.drawable.bg_line),
                        "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )

//                Edit profile
                    Spacer(Modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            .fillMaxWidth()
                            .clickable { navController.navigate("editProfile") },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_profile),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                "Edit Profile",
                                fontSize = 14.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            "",
                            modifier = Modifier.size(30.dp)
                        )

                    }
//                Rewards
                    Spacer(Modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_wallet),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                "Rewards",
                                fontSize = 14.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            "",
                            modifier = Modifier.size(30.dp)
                        )
                    }
//                Change password
                    Spacer(Modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            .fillMaxWidth().clickable { navController.navigate("forGotPassword") },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_change),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                "Change Password",
                                fontSize = 14.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            "",
                            modifier = Modifier.size(30.dp)
                        )

                    }
//                    Log out
                    Spacer(Modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            .fillMaxWidth()
                            .clickable {
                                // Menampilkan BottomSheet
                                isSheetOpen = true
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_logout),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                "Log Out",
                                fontSize = 14.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    // BottomSheet
                    if (isSheetOpen) {
                        ModalBottomSheet(
                            onDismissRequest = { isSheetOpen = false },
                            containerColor = Color.White
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 16.dp, end = 16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "Exit App?",
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,

                                    fontFamily = montserrat,
                                    fontSize = 30.sp
                                )
                                Spacer(Modifier.height(25.dp))
                                Text(
                                    "Are you sure want to exit the app?",
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Gray,
                                    fontFamily = montserrat,
                                    fontSize = 20.sp
                                )
                                Spacer(Modifier.height(25.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    // Tombol Cancel
                                    Button(
                                        border = BorderStroke(1.dp, Color.Black),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.White
                                        ),
                                        modifier = Modifier
                                            .width(160.dp)
                                            .height(50.dp),

                                        onClick = { isSheetOpen = false },
                                    ) {
                                        Text(
                                            text = "Cancel",
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black,
                                            fontFamily = montserrat,
                                            fontSize = 18.sp,
                                        )
                                    }
                                    // Tombol Log Out
                                    Button(
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color(27, 94, 60)
                                        ),
                                        modifier = Modifier
                                            .width(160.dp)
                                            .height(50.dp),
                                        onClick = {  authViewModel.signout() }
                                    ) {
                                        Text(
                                            text = "Exit",
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            fontFamily = montserrat,
                                            fontSize = 18.sp,
                                        )
                                    }
                                }
                                Spacer(Modifier.height(30.dp))
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "App version 1.0.0",
                            fontSize = 10.sp,
                            fontFamily = montserrat,
                            color = Color(84, 84, 84)
                        )
                    }
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
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "Naya Rafeza",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = montserrat
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "NayaRafeza123@gmail.com",
                    color = Color(84, 84, 84),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = montserrat
                )

            }


        }


    }
}

@Preview
@Composable
private fun preprofileSceen() {
    profileScreen(navController = rememberNavController(), authViewModel = AuthViewModel())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { showBottomSheet = true }
        ) {
            Text("Display partial bottom sheet")
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                sheetState = sheetState,
                onDismissRequest = { showBottomSheet = false }
            ) {
                Text(
                    "Swipe up to open sheet. Swipe down to dismiss.",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}