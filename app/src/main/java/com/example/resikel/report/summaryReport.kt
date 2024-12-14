package com.example.resikel.report

import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.resikel.R
import com.example.resikel.auth.AuthState
import com.example.resikel.auth.AuthViewModel
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.montserrat
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryGrey
import com.example.resikel.ui.theme.primaryWhite
import com.example.resikel.ui.theme.secondaryGreen
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SummaryReport(
    navController: NavController,
    authViewModel: AuthViewModel,
    description: String,
    locationCode: String,
    imageUriString: String?
) {
    val authState by authViewModel.authState.observeAsState(AuthState.Unauthenticated)
    val userEmail = when (authState) {
        is AuthState.Authenticated -> (authState as AuthState.Authenticated).user?.email
            ?: "Unknown User"

        else -> "Unknown User"
    }

    val imageUri = Uri.parse(imageUriString)
    val scrollState = rememberScrollState()
    val interactionSource = remember { MutableInteractionSource() }

    var showDialog by remember { mutableStateOf(false) } // State for dialog visibility

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Summary Report") },
            navigationIcon = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier

                        .size(56.dp)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(36.dp)
                        )
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            showDialog = true // Show dialog when clicked
                        }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrowleft),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = colorResource(R.color.main_green)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = primaryGreen,
                titleContentColor = primaryWhite,
                navigationIconContentColor = primaryWhite
            )
        )
    }) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = primaryWhite),
        ) {
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(color = primaryGrey)
                ) {
                    imageUri?.let {
                        AsyncImage(
                            model = it,
                            contentDescription = "Photo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                // Report description and location
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 2.dp),
                    colors = CardDefaults.cardColors(containerColor = primaryWhite),
                    elevation = CardDefaults.cardElevation(10.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Description",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(text = description, fontSize = 12.sp)
                        Text(text = "Location", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                        LocationMapView()
                    }
                }

                // Reporter info
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = primaryWhite),
                    elevation = CardDefaults.cardElevation(10.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(text = "Reporter", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Image(
                                painter = painterResource(R.drawable.user_default),
                                contentDescription = "nahidul",
                                modifier = Modifier
                                    .size(45.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color(64, 64, 64), CircleShape),
                                contentScale = ContentScale.Crop
                            )
                            Column {
                                Text(
                                    text = userEmail,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(text = "Report Created", fontSize = 12.sp)
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "24 October 2024",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                            Text(
                                text = "12:30:05 WIB",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }

                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = secondaryGreen),
                        modifier = Modifier
                            .height(80.dp)
                            .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 12.dp)
                            .weight(1f),
                        onClick = {
                            showDialog = true // Show dialog when clicked
                        }
                    ) {
                        Text(
                            text = "Back to Edit",
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            fontFamily = montserrat,
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = primaryGreen),
                        modifier = Modifier
                            .height(80.dp)
                            .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 12.dp)
                            .weight(1f),
                        onClick = {
                            navController.navigate("successScreen")
                        }
                    ) {
                        Text(
                            text = "Submit",
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            fontFamily = montserrat,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
    // Dialog implementation
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(
                    text = "Discard Changes?",
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Medium
                )
            },
            text = {
                Text(
                    text = "Are you sure you want to discard your changes and go back?",
                    fontFamily = montserrat
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    navController.popBackStack("reportScreen", inclusive = false)
                }) {
                    Text(text = "Discard", fontFamily = montserrat, fontWeight = FontWeight.Medium, color = colorResource(
                        R.color.main_green))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(text = "Cancel", fontFamily = montserrat, fontWeight = FontWeight.Medium, color = colorResource(
                        R.color.main_green))
                }
            }
        )
    }
}


@Composable
fun LocationMapView() {
    val context = LocalContext.current
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    var location by remember { mutableStateOf<Location?>(null) }
    var address by remember { mutableStateOf("Fetching address...") } // State untuk alamat

    LaunchedEffect(Unit) {
        fusedLocationClient.lastLocation.addOnSuccessListener { loc: Location? ->
            location = loc
            loc?.let {
                // Mendapatkan alamat menggunakan Geocoder
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                address = addresses?.firstOrNull()?.getAddressLine(0) ?: "Unknown Location"
            }
        }
    }

    location?.let {
        // Tampilkan alamat di bawah peta
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = primaryGreen)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = address,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        GoogleMap(
            modifier = Modifier.fillMaxWidth().height(150.dp),
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(
                    LatLng(it.latitude, it.longitude), 15f
                )
            }
        ) {
            Marker(
                state = MarkerState(LatLng(it.latitude, it.longitude)),
                title = "Your Location"
            )
        }
    }
}




