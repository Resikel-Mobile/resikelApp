package com.example.resikel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.resikel.ui.theme.montserrat

@Composable
fun homeScreen(modifier: Modifier = Modifier, navController: NavController) {
    val scrollState = rememberScrollState()
    val items = listOf("Gopay", "shopeepay", "Ovo", "dana", "Item 5")

    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(Color.White)
    ) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            tonalElevation = 40.dp,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = "nahidul",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Green, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(6.dp)
                ) {
                    Text("Naya Rafeza", fontWeight = FontWeight.Bold)
                    Text("ya hallo semua~")
                }

            }
        }
        Text(
            text = "What do you want to do today?",
            modifier = Modifier.padding(15.dp),
            fontFamily = montserrat,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    onClick = {},
                    modifier = Modifier.size(65.dp),
                    shape = RoundedCornerShape(33.dp),
                    color = Color.Red,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Face,
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp),

                        )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Community",
                    fontFamily = montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    onClick = {},
                    modifier = Modifier.size(65.dp),
                    shape = RoundedCornerShape(33.dp),
                    color = Color.Red,
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp),

                        )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Location",
                    fontFamily = montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    onClick = {},
                    modifier = Modifier.size(65.dp),
                    shape = RoundedCornerShape(33.dp),
                    color = Color.Red,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp),

                        )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Report",
                    fontFamily = montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    onClick = {},
                    modifier = Modifier.size(65.dp),
                    shape = RoundedCornerShape(33.dp),
                    color = Color.Red,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp),
                    )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Pick Up",
                    fontFamily = montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Spacer(Modifier.height(25.dp))
        Text(
            text = "Transfer", modifier = Modifier.padding(15.dp),
            fontFamily = montserrat,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(), // Mengisi lebar layar
            horizontalArrangement = Arrangement.spacedBy(10.dp), // Memberikan jarak antar item
            contentPadding = PaddingValues(horizontal = 16.dp) // Padding di awal dan akhir
        ) {
            items(items) { item ->
                // Setiap item di dalam LazyRow
                Surface(
                    shadowElevation = 12.dp,
                    shape = RoundedCornerShape(5.dp),
                    color = Color.Gray,
                    modifier = Modifier
                        .size(110.dp)
                        .padding(5.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
                        Spacer(Modifier.height(10.dp))
                        Text(text = item, color = Color.White)
                    }

                }
            }
        }
        Spacer(Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Today's Information", modifier = Modifier.padding(15.dp),
                fontFamily = montserrat,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "See more", modifier = Modifier.padding(15.dp),
                fontFamily = montserrat,
                fontSize = 14.sp,
                color = Color(27, 94, 60),
                fontWeight = FontWeight.Bold
            )
        }
        Surface(
            color = Color.Gray,
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .height(200.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.contethome),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse non metus a ipsum fermentum fermentum vel et ligula. Mauris mattis, nulla eget tempus porta, sem augue iaculis ante, vel tristique orci ante a eros.",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
        Surface(
            color = Color.Gray,
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .height(200.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(R.drawable.contethome),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse non metus a ipsum fermentum fermentum vel et ligula. Mauris mattis, nulla eget tempus porta, sem augue iaculis ante, vel tristique orci ante a eros.",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

    }
}

