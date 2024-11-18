package com.example.resikelapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.resikel.R
import com.example.resikel.homeScreen
import com.example.resikel.navigation.onproggress
import com.example.resikel.profile.editProfile
import com.example.resikel.profile.profileScreen
import com.example.resikel.report.ReportScreen
import com.example.resikel.report.SuccessReport
import com.example.resikel.report.SummaryReport

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun resikelApp(
    navController: NavHostController = rememberNavController()
) {


    val noTopBarScreens = listOf(
        "homeScreen",
        "reportScreen",
        "summaryScreen",
        "successScreen",
        "profileScreen",
        "editProfile"
    )
    val noBottomBarScreens = listOf("reportScreen", "summaryScreen", "successScreen", "editProfile")

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            if (currentDestination !in noTopBarScreens) {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(27, 94, 60)),
                    title = {
                        Text(
                            text = when (currentDestination) {
                                "historyScreen" -> "History"
                                "profileScreen" -> "Profile"
                                else -> "ResikelApp"
                            },
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                )
            }
        },

        bottomBar = {
            if (currentDestination !in noBottomBarScreens) {
                navBottomResikel(navController = navController)
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding()
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "homeScreen"
                ) {
                    composable("homeScreen") { homeScreen(navController = navController) }
                    composable("historyScreen") { onproggress() }
                    composable("profileScreen") { onproggress() }
                    composable("reportScreen") { ReportScreen(navController = navController) }
                    composable("summaryScreen") { SummaryReport(navController = navController) }
                    composable("successScreen") { SuccessReport(navController = navController) }
                    composable("profileScreen") { profileScreen(navController = navController) }
                    composable("editProfile") { editProfile(navController = navController) }
                }
            }
        }
    )
}

@Composable
fun navBottomResikel(
    navController: NavHostController,
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    var selectedItem by remember { mutableStateOf("homeScreen") }

    Box {
        Image(
            painter = painterResource(R.drawable.bgnav),
            contentDescription = "",
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        // Bottom Navigation Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 15.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            IconButton(onClick = {
                selectedItem = "homeScreen"
                navController.navigate("homeScreen") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }
            ) {
                Image(
                    painter = painterResource(if (currentDestination == "homeScreen") R.drawable.ic_home_aktif else R.drawable.ic_home),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                )
            }
            IconButton(onClick = {
                selectedItem = "historyScreen"
                navController.navigate("historyScreen") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }) {
                Image(
                    painter = painterResource(if (currentDestination == "historyScreen") R.drawable.ic_analy_aktif else R.drawable.ic_analy),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                )
            }
            Spacer(Modifier.width(56.dp)) // Space for the FAB in the middle
            IconButton(onClick = {
                selectedItem = "profileScreen"
                navController.navigate("profileScreen") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }) {
                Image(
                    painter = painterResource(if (currentDestination == "profileScreen") R.drawable.ic_hist_aktif else R.drawable.ic_hist),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = {
                selectedItem = "profileScreen"
                navController.navigate("profileScreen") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }) {
                Image(
                    painter = painterResource(if (currentDestination == "profileScreen") R.drawable.ic_prof_aktif else R.drawable.ic_prof),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )
            }
        }


        // Floating Action Button in the Center
        FloatingActionButton(
            containerColor = Color(27, 94, 60),
            contentColor = Color.White,
            shape = RoundedCornerShape(35.dp),
            onClick = { /* action */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(68.dp)
                .offset(y = -62.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_kamera),
                contentDescription = "Camera",
                modifier = Modifier.size(25.dp)
            )
        }
    }

}

@Preview
@Composable
private fun preee() {
    resikelApp()
}