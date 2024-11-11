package com.example.resikel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.resikel.auth.signIn
import com.example.resikel.auth.signUp
import com.example.resikel.auth.welcomeResikel
import com.example.resikel.homeScreen
import com.example.resikel.report.ReportScreen
import com.example.resikel.report.SuccessReport
import com.example.resikel.report.SummaryReport

import com.example.resikelapp.resikelApp


@Composable
fun resikelNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome_resikel") {
        composable("welcome_resikel"){ welcomeResikel(navController) }
        composable("sign_in") { signIn(navController) }
        composable("sign_up"){ signUp(navController = navController) }
        composable("resikel_app"){ resikelApp() }
        composable("home_screen"){ homeScreen(navController = navController) }
        composable("reportScreen"){ ReportScreen(navController = navController) }
        composable("summaryScreen"){ SummaryReport(navController = navController) }
        composable("successScreen"){ SuccessReport(navController = navController) }
    }
}