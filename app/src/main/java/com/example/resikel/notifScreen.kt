package com.example.resikel

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.resikel.ui.theme.montserrat

@Composable
fun notifScreen(modifier: Modifier = Modifier, navController: NavController) {
    val interactionSource = remember { MutableInteractionSource() }
    Column {
        Box(
            modifier = Modifier
                .background(colorResource(R.color.main_green))
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 20.dp, start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(56.dp)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .background(
                            color = colorResource(R.color.white),
                            shape = RoundedCornerShape(36.dp)
                        )
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            navController.popBackStack()
                        }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrowleft),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = colorResource(R.color.main_green)
                    )
                }
                Text(
                    "Notifications",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = montserrat,
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(56.dp)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .background(
                            color = Color.Transparent,
                            shape = RoundedCornerShape(36.dp)
                        )
                        .clickable(

                        ) {
                        }
                ) {
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp, top = 12.dp, bottom = 8.dp)
        ) {
            Text(
                text = "Recent",
                fontSize = 20.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Mark all as read", fontSize = 14.sp, fontFamily = montserrat)
        }
        LazyColumn { items(15) { listNotif() } }
    }

}

@Preview
@Composable
private fun prenotifScreen() {
    notifScreen(navController = rememberNavController())
}

@Composable
fun listNotif() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.pp),
            contentDescription = "nahidul",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(12.dp))
        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Naya Rafeza",
                    fontSize = 17.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(text = "1 hour ago", color = Color(64, 64, 64), fontSize = 11.sp)
            }

            Text(
                text = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati atque...",
                fontSize = 12.sp,
                lineHeight = 12.sp,
                fontFamily = montserrat,
                color = Color(64, 64, 64)
            )
        }

    }
}

@Preview
@Composable
private fun prelist() {
    listNotif()
}