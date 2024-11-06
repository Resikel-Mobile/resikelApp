package com.example.resikel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun resikelApp(modifier: Modifier = Modifier) {
   Scaffold(Modifier.safeContentPadding(),
       topBar = { Text("RESIKEL") },
       bottomBar = { CustomBottomBarWithFAB() },
       content = {paddingValues ->   Row(modifier = Modifier.padding(paddingValues)) {
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

       } }
   )
}

@Composable
fun CustomBottomBarWithFAB(modifier: Modifier = Modifier) {
    Box{
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
                .padding(bottom = 25.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color(27, 94, 60))
            Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorites", tint = Color(27, 94, 60))
            Spacer(Modifier.width(56.dp)) // Space for the FAB in the middle
            Icon(Icons.Default.Share, contentDescription = "Security", tint = Color(27, 94, 60))
            Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color(27, 94, 60))
        }


        // Floating Action Button in the Center
        FloatingActionButton(
            containerColor = Color(27,94,60),
            contentColor = Color.White,
            shape = RoundedCornerShape(35.dp),
            onClick = { /* action */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(68.dp)
                .offset(y = -62.dp)
        ) {
            Icon(Icons.Default.Face, contentDescription = "Camera")
        }
    }
}




@Preview(showBackground = true)
@Composable
private fun resikelp() {
    resikelApp()
}