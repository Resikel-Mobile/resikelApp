package com.example.resikel.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.R
import com.example.resikel.ui.theme.montserrat

@Composable
fun signUp(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(30.dp))
        Image(
            painter = painterResource(R.drawable.logosignup),
            contentDescription = "logo",
            Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 10.dp, end = 40.dp, start = 40.dp),
            contentScale = ContentScale.Crop
        )
        TextField(
            placeholder = { Text("Username") },
            value = name,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(242, 243, 247),
                unfocusedContainerColor = Color(242, 243, 247),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 25.dp, end = 25.dp, bottom = 8.dp)
        )
        TextField(
            placeholder = { Text("Email") },
            trailingIcon = { Icon(imageVector = Icons.Filled.Done, contentDescription = "") },
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
                .padding(top = 9.dp, start = 25.dp, end = 25.dp, bottom = 8.dp)
        )
        TextField(
            placeholder = { Text("Password") },
            trailingIcon = { Icon(imageVector = Icons.Filled.Done, contentDescription = "")},
            value = password,
            shape = RoundedCornerShape(15.dp),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(242, 243, 247),
                unfocusedContainerColor = Color(242, 243, 247),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 9.dp, start = 25.dp, end = 25.dp, bottom = 6.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                Text(
                    text = "I have read the ",
                    color = Color(161, 164, 178),
                    fontFamily = montserrat,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    text = "privacy policy.",
                    color = Color(27, 94, 60),
                    fontFamily = montserrat,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }
        Spacer(Modifier.height(20.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(27, 94, 60)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 8.dp),
            onClick = {}) {
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontFamily = montserrat,
                fontSize = 22.sp,
            )
        }
        Button(
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 6.dp, start = 22.dp, end = 22.dp, bottom = 12.dp),
            onClick = {}) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    tint = Color.Unspecified,
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.ic_google), // Replace with your icon resource
                    contentDescription = "Button Icon",
                )
                Text(
                    text = "Sign Up Google",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontFamily = montserrat,
                    fontSize = 18.sp,
                )
                Icon(
                    tint = Color.Transparent,
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.ic_google), // Replace with your icon resource
                    contentDescription = "Button Icon",
                )
            }

        }
    }
}

@Preview
@Composable
private fun prev() {
    signUp()
}