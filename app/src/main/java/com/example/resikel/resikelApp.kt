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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.resikel.R
import com.example.resikel.analisis.analisisScreen
import com.example.resikel.auth.AuthViewModel
import com.example.resikel.auth.forGotPassword
import com.example.resikel.auth.signIn
import com.example.resikel.auth.signUp
import com.example.resikel.chatbot.ChatViewModel
import com.example.resikel.chatbot.chatScreen
import com.example.resikel.community.CommunityChat
import com.example.resikel.community.CommunityDetail
import com.example.resikel.community.CommunityMember
import com.example.resikel.community.CommunityScreen
import com.example.resikel.community.MyCommunity
import com.example.resikel.community.PersonalChat

import com.example.resikel.detailInformasi
import com.example.resikel.historyScreen
import com.example.resikel.homeScreen
import com.example.resikel.intro.onBoardingDua
import com.example.resikel.intro.onBoardingSatu
import com.example.resikel.location.MapScreen
import com.example.resikel.navigation.onproggress
import com.example.resikel.notifScreen
import com.example.resikel.pickup.pickupScreen
import com.example.resikel.pickup.setLocation
import com.example.resikel.pickup.successDelivery
import com.example.resikel.pickup.trackingOrder
import com.example.resikel.pickup.trashItemList
import com.example.resikel.profile.editProfile

import com.example.resikel.profile.profileScreen
import com.example.resikel.report.ReportScreen
import com.example.resikel.report.SuccessReport
import com.example.resikel.report.SummaryReport
import com.example.resikel.tukarPoin
import com.example.resikel.viewmodel.MapViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun resikelApp(
    navController: NavHostController = rememberNavController()
) {


    val noTopBarScreens = listOf(
        "homeScreen",
        "resikelApp",
        "reportScreen",
        "summaryScreen?description={description}&location={location}&imageUri={imageUri}",
        "successScreen",
        "profileScreen",
        "editProfile",
        "historyScreen",
        "pickupScreen",
        "trashItemList",
        "setLocation",
        "trackingOrder",
        "successDelivery",
        "notifScreen",
        "locationScreen",
        "analisisScreen",
        "forGotPassword",
        "CommunityChat",
        "MyCommunity",
        "CommunityScreen",
        "CommunityDetail",
        "CommunityMember",
        "PersonalChat",
        "detailInformasi", "sign_in", "sign_up","chatScreen"
    )
    val noBottomBarScreens = listOf(
        "reportScreen",
        "summaryScreen?description={description}&location={location}&imageUri={imageUri}",
        "successScreen",
        "editProfile",
        "pickupScreen",
        "trashItemList",
        "setLocation",
        "trackingOrder",
        "successDelivery",
        "notifScreen",
        "locationScreen",
        "CommunityChat",
        "MyCommunity",
        "CommunityScreen",
        "CommunityDetail",
        "CommunityMember",
        "PersonalChat","detailInformasi",
        "forGotPassword", "sign_in", "sign_up","chatScreen"
    )

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
                                "profileScreen" -> "Profile"
                                "analisisScreen" -> "Grafik"
                                else -> "On Proggress"
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
                    composable("sign_in") { signIn(navController, authViewModel = AuthViewModel()) }
                    composable("sign_up") {
                        signUp(
                            navController = navController,
                            authViewModel = AuthViewModel()
                        )
                    }
                    composable("resikelApp") { resikelApp() }
                    composable("onBoardingSatu") {
                        onBoardingSatu(
                            navController = navController,
                            authViewModel = AuthViewModel()
                        )
                    }
                    composable("homeScreen") { homeScreen(navController = navController, authViewModel = AuthViewModel()) }
                    composable("onProggress") { onproggress() }
                    composable("notifScreen") { notifScreen(navController = navController) }
                    composable("historyScreen") { historyScreen() }
                    composable("analisisScreen") { analisisScreen() }
                    composable("reportScreen") { ReportScreen(navController = navController, authViewModel = AuthViewModel()) }
                    composable("tukarPoin") { tukarPoin() }
                    composable("pickupScreen") { pickupScreen(navController = navController) }
                    composable("trashItemList") { trashItemList(navController = navController) }
                    composable("setLocation") { setLocation(navController = navController) }
                    composable("trackingOrder") { trackingOrder(navController = navController) }
                    composable("successDelivery") { successDelivery(navController = navController) }
                    composable(
                        "summaryScreen?description={description}&location={location}&imageUri={imageUri}",
                        arguments = listOf(
                            navArgument("description") { type = NavType.StringType },
                            navArgument("location") { type = NavType.StringType },
                            navArgument("imageUri") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val description = backStackEntry.arguments?.getString("description") ?: ""
                        val locationCode = backStackEntry.arguments?.getString("location") ?: ""
                        val imageUriString = backStackEntry.arguments?.getString("imageUri")

                        SummaryReport(
                            navController = navController,
                            authViewModel = AuthViewModel(), // Inisialisasi atau gunakan DI jika ada
                            description = description,
                            locationCode = locationCode,
                            imageUriString = imageUriString
                        )
                    }

                    composable("successScreen") { SuccessReport(navController = navController) }
                    composable("profileScreen") {
                        profileScreen(
                            navController = navController,
                            authViewModel = AuthViewModel()
                        )
                    }
                    composable("editProfile") { editProfile(navController = navController) }
                    composable("MyCommunity") { MyCommunity(navController = navController) }
                    composable("CommunityScreen") { CommunityScreen(navController = navController) }
                    composable("CommunityChat") { CommunityChat(navController = navController) }
                    composable("CommunityDetail") { CommunityDetail(navController = navController) }
                    composable("CommunityMember") { CommunityMember(navController = navController) }
                    composable("PersonalChat") { PersonalChat(navController = navController) }
                    composable("locationScreen") { MapScreen() }
                    composable("detailInformasi") { detailInformasi(navController = navController) }
                    composable("forGotPassword") { forGotPassword(navController = navController) }
                    composable("chatScreen") { chatScreen(navController = navController, chatViewModel = ChatViewModel()) }
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

    // Sinkronkan selectedItem dengan rute saat ini
    selectedItem = currentDestination ?: "homeScreen"

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
                selectedItem = "analisisScreen"
                navController.navigate("AnalisisScreen") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }) {
                Image(
                    painter = painterResource(if (currentDestination == "analisisScreen") R.drawable.ic_analy_aktif else R.drawable.ic_analy),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                )
            }
            Spacer(Modifier.width(56.dp)) // Space for the FAB in the middle
            IconButton(onClick = {
                selectedItem = "historyScreen"
                navController.navigate("historyScreen") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }) {
                Image(
                    painter = painterResource(if (currentDestination == "historyScreen") R.drawable.ic_hist_aktif else R.drawable.ic_hist),
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
            onClick = { },
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