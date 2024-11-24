package com.example.resikel.analisis

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.R
import com.example.resikel.listNotif
import com.example.resikel.pickup.TrackingOrderBody
import com.example.resikel.ui.theme.SimpleTextButton
import com.example.resikel.ui.theme.montserrat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun analisisScreen(modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    Scaffold(topBar = {
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.main_green))
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                            interactionSource = interactionSource,
                            indication = null
                        ) {

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
                    "Grafik",
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
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                        }
                ) {
                }
            }
        }
    }
    ) {

        contentAnalisi()
    }
}

@Composable
fun contentAnalisi(modifier: Modifier = Modifier) {
    var statusFilter = 0
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        Spacer(Modifier.height(100.dp))
        Image(
            painter = painterResource(R.drawable.img_analisis),
            "",
            contentScale = ContentScale.Fit, modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        LazyRow(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                SimpleTextButton(
                    backgroundColor = if (statusFilter == 0) colorResource(id = R.color.main_green) else Color.Transparent,
                    textContent = "Today",
                    textPaddingHorizontal = 24.dp,
                    textPaddingVertical = 9.dp,
                    backgroundRadius = 34.dp,
                    textStyle = TextStyle(fontWeight = FontWeight.ExtraBold),
                    textSize = 15.sp,
                    textColor = if (statusFilter == 0) Color.White else colorResource(id = R.color.main_green),
                    onClickListener = { if (statusFilter != 0) statusFilter = 0 }
                )
            }
            item {
                SimpleTextButton(
                    backgroundColor = if (statusFilter == 1) colorResource(id = R.color.main_green) else Color.Transparent,
                    textContent = "Weekly",
                    backgroundRadius = 34.dp,
                    textPaddingHorizontal = 20.dp,
                    textPaddingVertical = 9.dp,
                    textStyle = TextStyle(fontWeight = FontWeight.ExtraBold),
                    textSize = 15.sp,
                    textColor = if (statusFilter == 1) Color.White else colorResource(id = R.color.main_green),
                    onClickListener = { if (statusFilter != 1) statusFilter = 1 }
                )
            }
            item {
                SimpleTextButton(
                    backgroundColor = if (statusFilter == 2) colorResource(id = R.color.main_green) else Color.Transparent,
                    textContent = "Monthly",
                    backgroundRadius = 34.dp,
                    textPaddingHorizontal = 16.dp,
                    textPaddingVertical = 9.dp,
                    textStyle = TextStyle(fontWeight = FontWeight.ExtraBold),
                    textSize = 15.sp,
                    textColor = if (statusFilter == 2) Color.White else colorResource(id = R.color.main_green),
                    onClickListener = { if (statusFilter != 2) statusFilter = 2 }
                )
            }
            item {
                SimpleTextButton(
                    backgroundColor = if (statusFilter == 3) colorResource(id = R.color.main_green) else Color.Transparent,
                    textContent = "Year",
                    backgroundRadius = 34.dp,
                    textStyle = TextStyle(fontWeight = FontWeight.ExtraBold),
                    textSize = 15.sp,
                    textPaddingHorizontal = 18.dp,
                    textPaddingVertical = 9.dp,
                    textColor = if (statusFilter == 3) Color.White else colorResource(id = R.color.main_green),
                    onClickListener = { if (statusFilter != 3) statusFilter = 3 }
                )
            }
        }
//        Additional information vertical list
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Additional information",
                fontFamily = montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Row {
                Text(
                    "ASC", fontFamily = montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    " | DSC", fontFamily = montserrat,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
        }
//list barang nya
        LazyColumn {
            items(10) { listBarangAnalisis() }
        }


    }
}

@Composable
fun listBarangAnalisis(modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 4.dp, modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 8.dp)
        ) {
            Surface(
                modifier = Modifier.size(38.dp),
                shape = RoundedCornerShape(6.dp),
                color = Color(243, 243, 243),
            ) {
                Image(
                    painter = painterResource(R.drawable.cardboard),
                    contentDescription = "",
                    modifier = Modifier.padding(6.dp)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Cardboard",
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
                Text(
                    "27068921 Kg",
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Normal,
                    color = Color(153,153,153),
                    fontSize = 14.sp
                )
            }

        }
    }

}


@Preview
@Composable
private fun preanalisisScreen() {
    analisisScreen()
}