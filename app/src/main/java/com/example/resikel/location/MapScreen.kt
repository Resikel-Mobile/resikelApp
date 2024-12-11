package com.example.resikel.location
import android.content.pm.PackageManager
import android.location.Geocoder
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.resikel.report.SummaryReport
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryWhite
import com.example.resikel.viewmodel.MapViewModel
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerComposable
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import java.util.Locale

@Composable
fun MapScreen() {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }

    // Sample data for TPS locations
    val tpsLocations = listOf(
        LatLng(1.1549956364659981, 104.12230730292788) to "PMPS",
        LatLng(1.0529915647756551, 104.1241195158386) to "TPA Punggur"
    )

    // State untuk lokasi pengguna dan alamat
    val userLocation = remember { mutableStateOf<LatLng?>(null) }
    val address = remember { mutableStateOf("Fetching address...") }

    // Camera position state
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(userLocation.value ?: LatLng(40.9971, 29.1007), 15f)
    }

    // Handle location permission
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Fetch the location once permission is granted
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    // Set lokasi saat ini
                    userLocation.value = LatLng(it.latitude, it.longitude)

                    // Ambil alamat berdasarkan lokasi
                    val geocoder = Geocoder(context, Locale.getDefault())
                    val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                    address.value = addresses?.firstOrNull()?.getAddressLine(0) ?: "Alamat tidak ditemukan"

                    // Update camera position ke lokasi pengguna
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(userLocation.value ?: LatLng(40.9971, 29.1007), 15f)

                    // Debugging log untuk memastikan lokasi ditemukan
                    Log.d("MapScreen", "User location: ${it.latitude}, ${it.longitude}")
                } ?: Log.e("MapScreen", "Location is null")
            }
        } else {
            Log.e("MapScreen", "Permission denied")
        }
    }

    // Launch effect to handle location fetching logic
    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    userLocation.value = LatLng(it.latitude, it.longitude)
                    // Ambil alamat berdasarkan lokasi
                    val geocoder = Geocoder(context, Locale.getDefault())
                    val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                    address.value = addresses?.firstOrNull()?.getAddressLine(0) ?: "Alamat tidak ditemukan"

                    // Update camera position ke lokasi pengguna
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(userLocation.value ?: LatLng(40.9971, 29.1007), 15f)

                    // Debugging log untuk memastikan lokasi ditemukan
                    Log.d("MapScreen", "User location: ${it.latitude}, ${it.longitude}")
                }
            }
        } else {
            permissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Google Map Section
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            cameraPositionState = cameraPositionState
        ) {
            // Marker for user location (added dynamically)
            userLocation.value?.let { location ->
                Marker(
                    state = MarkerState(position = location),
                    title = "Your Location",
                    snippet = address.value, // Display the address here
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
                )
            }

            // Markers for TPS locations
            tpsLocations.forEach { (location, title) ->
                Marker(
                    state = MarkerState(position = location),
                    title = title,
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                )
            }
        }

        // Route Section
        Column(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(color = primaryGreen)
                    .padding(14.dp)
            ) {
                Text(
                    text = "Maps",
                    fontWeight = FontWeight.Bold,
                    color = primaryWhite,
                    fontSize = 18.sp
                )
            }
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(color = primaryWhite)
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Your route", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                // User location display
                userLocation.value?.let {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                        Text(text = "Your Location: ${address.value}") // Show the address here
                    }
                } ?: Text("Fetching your location...") // Will display until the location is fetched

                HorizontalDivider()

                // Display TPS locations
                tpsLocations.forEach { (_, title) ->
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null
                        )
                        Text(text = title)
                    }
                    HorizontalDivider()
                }
            }
        }
    }
}


/*
@Preview(showBackground = true)
@Composable
private fun MapScreenPreview() {
    ResikelTheme {
        MapScreen()
    }
}*/