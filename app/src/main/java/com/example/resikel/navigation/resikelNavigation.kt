package com.example.resikel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.resikel.auth.AuthViewModel
import com.example.resikel.auth.forGotPassword
import com.example.resikel.auth.signIn
import com.example.resikel.auth.signUp
import com.example.resikel.auth.welcomeResikel
import com.example.resikel.homeScreen
import com.example.resikel.intro.onBoardingDua
import com.example.resikel.intro.onBoardingEmpat
import com.example.resikel.intro.onBoardingSatu
import com.example.resikel.intro.onBoardingTiga
import com.example.resikel.report.ReportScreen
import com.example.resikel.report.SuccessReport
import com.example.resikel.report.SummaryReport
import com.example.resikel.splashScreen

import com.example.resikelapp.resikelApp


@Composable
fun resikelNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { splashScreen(navController = navController) }
        composable("onBoardingSatu") { onBoardingSatu(navController = navController, authViewModel = authViewModel) }
        composable("onBoardingDua") { onBoardingDua(navController = navController) }
        composable("onBoardingTiga") { onBoardingTiga(navController = navController) }
        composable("onBoardingEmpat") { onBoardingEmpat(navController = navController) }
        composable("welcome_resikel"){ welcomeResikel(navController) }
        composable("sign_in") { signIn(navController,authViewModel) }
        composable("sign_up"){ signUp(navController = navController, authViewModel = authViewModel) }
        composable("forGotPassword") { forGotPassword(navController = navController) }
        composable("resikelApp"){ resikelApp() }
        composable("home_screen"){ homeScreen(navController = navController) }
        composable("reportScreen"){ ReportScreen(navController = navController) }
        composable("summaryScreen"){ SummaryReport(navController = navController) }
        composable("successScreen"){ SuccessReport(navController = navController) }
    }
}