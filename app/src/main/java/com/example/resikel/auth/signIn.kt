package com.example.resikel.auth

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.resikel.R
import com.example.resikel.ui.theme.montserrat

@Composable
fun signIn(
    navController: NavController,
    authViewModel: AuthViewModel,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> {
                // Ambil data pengguna dari Firestore setelah login berhasil
                val userId = (authState.value as AuthState.Authenticated).user?.uid
                if (userId != null) {
                    authViewModel.fetchUserData(userId)
                }
                // Navigasi ke halaman utama
                navController.navigate("resikelApp")
            }
            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT
            ).show()
            else -> Unit
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.logosignin),
            contentDescription = "",
            Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 10.dp, end = 40.dp, start = 40.dp),
            contentScale = ContentScale.Crop
        )
        TextField(
            placeholder = { Text("Email") },
            value = email,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(242, 243, 247),
                unfocusedContainerColor = Color(242, 243, 247),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 25.dp, end = 25.dp, bottom = 8.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Image(
                        painter = painterResource(
                            id = if (isPasswordVisible) R.drawable.ic_see else R.drawable.ic_dontsee
                        ),
                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(242, 243, 247),
                unfocusedContainerColor = Color(242, 243, 247),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 9.dp, start = 25.dp, end = 25.dp, bottom = 6.dp)
        )
        Spacer(Modifier.height(35.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(27, 94, 60)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 10.dp),
            onClick = { authViewModel.login(email, password) },
            enabled = authState.value != AuthState.Loading
        ) {
            Text(
                text = "Sign In",
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontFamily = montserrat,
                fontSize = 22.sp,
            )
        }
        Text(
            modifier = Modifier
                .padding(10.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { navController.navigate("forGotPassword") },
            text = "Forgot your password?",
            color = Color(161, 164, 178),
            fontSize = 12.sp,
            fontFamily = montserrat,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(10.dp))
        Row {
            Text(
                text = "You don't have an account yet? ", color = Color(161, 164, 178),
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight.Normal
            )
            Text(
                modifier = Modifier.clickable { navController.navigate("sign_up") },
                text = "Sign up", color = Color(45, 204, 112),
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight.Normal
            )
        }
    }
}


@Preview
@Composable
private fun prelogin() {
    signIn(navController = rememberNavController(), authViewModel = AuthViewModel())
}
