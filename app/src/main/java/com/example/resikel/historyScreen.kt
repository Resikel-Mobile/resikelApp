package com.example.resikel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.ui.theme.SimpleTextButton
import com.example.resikel.ui.theme.iconWithBackground
import com.example.resikel.ui.theme.montserrat

@Composable
fun historyScreen(modifier: Modifier = Modifier) {
    var statusFilter = 0
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.main_green))
            .fillMaxSize()
    ) {
        Text(
            "History",
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = montserrat,
            modifier = Modifier
                .fillMaxWidth().padding(top = 55.dp)

        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 115.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                )
                .align(Alignment.BottomCenter),
        ) {
            Column(
                Modifier
                    .fillMaxSize()
            ) {
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .padding(top = 32.dp, bottom = 12.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    item {
                        SimpleTextButton(
                            backgroundColor = if (statusFilter == 0) colorResource(id = R.color.main_green) else colorResource(
                                id = R.color.main_green
                            ),
                            textContent = "All",
                            textPaddingHorizontal = 32.dp,
                            textPaddingVertical = 8.dp,
                            backgroundRadius = 4.dp,
                            textStyle = TextStyle(fontWeight = FontWeight.ExtraBold),
                            textSize = 16.sp,
                            textColor = if (statusFilter == 0) Color.White else colorResource(id = R.color.main_green),
                            onClickListener = { if (statusFilter != 0) statusFilter = 0 }
                        )
                    }
                    item {
                        SimpleTextButton(
                            backgroundColor = if (statusFilter == 1) colorResource(id = R.color.main_green) else colorResource(
                                id = R.color.light_green3
                            ),
                            textContent = "Pickup",
                            backgroundRadius = 4.dp,
                            textPaddingHorizontal = 32.dp,
                            textPaddingVertical = 8.dp,
                            textStyle = TextStyle(fontWeight = FontWeight.ExtraBold),
                            textSize = 16.sp,
                            textColor = if (statusFilter == 1) Color.White else colorResource(id = R.color.main_green),
                            onClickListener = { if (statusFilter != 1) statusFilter = 1 }
                        )
                    }
                    item {
                        SimpleTextButton(
                            backgroundColor = if (statusFilter == 2) colorResource(id = R.color.main_green) else colorResource(
                                id = R.color.light_green3
                            ),
                            textContent = "Delivery",
                            backgroundRadius = 4.dp,
                            textPaddingHorizontal = 32.dp,
                            textPaddingVertical = 8.dp,
                            textStyle = TextStyle(fontWeight = FontWeight.ExtraBold),
                            textSize = 16.sp,
                            textColor = if (statusFilter == 2) Color.White else colorResource(id = R.color.main_green),
                            onClickListener = { if (statusFilter != 2) statusFilter = 2 }
                        )
                    }
                    item {
                        SimpleTextButton(
                            backgroundColor = if (statusFilter == 3) colorResource(id = R.color.main_green) else colorResource(
                                id = R.color.light_green3
                            ),
                            textContent = "Canceled",
                            backgroundRadius = 4.dp,
                            textStyle = TextStyle(fontWeight = FontWeight.ExtraBold),
                            textSize = 16.sp,
                            textPaddingHorizontal = 32.dp,
                            textPaddingVertical = 8.dp,
                            textColor = if (statusFilter == 3) Color.White else colorResource(id = R.color.main_green),
                            onClickListener = { if (statusFilter != 3) statusFilter = 3 }
                        )
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                )
                {
                    item {
                        HistoryCardItem(
                            orderid = "#71821",
                            status = "Pickup",
                            startLoc = "Waste station pungur",
                            endLoc = "Telaga Punggur, Kota Batam",
                            date = "12/01/2024",
                            driverName = "Milo Enak",
                            vehicleNumber = "BP 1289 HGQ"
                        )
                    }

                    item {
                        HistoryCardItem(
                            orderid = "#71822",
                            status = "Cancelled",
                            startLoc = "Recycling Center Batam",
                            endLoc = "Tiban Indah, Kota Batam",
                            date = "13/01/2024",
                            driverName = "Budi Harsono",
                            vehicleNumber = "BP 2231 KJH"
                        )
                    }
                    item {
                        HistoryCardItem(
                            orderid = "#71823",
                            status = "Cancelled",
                            startLoc = "Waste Facility Nagoya",
                            endLoc = "Sei Jodoh, Kota Batam",
                            date = "14/01/2024",
                            driverName = "Siti Rohimah",
                            vehicleNumber = "BP 9832 LMN"
                        )
                    }
                    item {
                        HistoryCardItem(
                            orderid = "#71824",
                            status = "Pickup",
                            startLoc = "Tanjung Riau Waste Depot",
                            endLoc = "Batu Ampar Port",
                            date = "15/01/2024",
                            driverName = "Ahmad Santoso",
                            vehicleNumber = "BP 3478 ZXC"
                        )
                    }
                    item {
                        HistoryCardItem(
                            orderid = "#71826",
                            status = "Cancelled",
                            startLoc = "Punggur Waste Terminal",
                            endLoc = "Teluk Tering, Kota Batam",
                            date = "17/01/2024",
                            driverName = "Rio Fernando",
                            vehicleNumber = "BP 7893 HJK"
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun HistoryCardItem(
    orderid: String,
    status: String,
    startLoc: String,
    endLoc: String,
    date: String,
    driverName: String,
    vehicleNumber: String,
) {
    val displayTextStart = if (startLoc.length > 16) {
        startLoc.take(16) + "..."
    } else {
        startLoc
    }

    val displayTextEnd = if (endLoc.length > 16) {
        endLoc.take(16) + "..."
    } else {
        endLoc
    }

    Box(
        modifier = Modifier
            .padding(24.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .wrapContentSize()
            .fillMaxWidth()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 28.dp, vertical = 20.dp)
                    .background(color = Color.White)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        text = orderid,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .fillMaxWidth(),
                        fontFamily = montserrat,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.black),
                    )
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.CenterEnd)
                    ) {
                        SimpleTextButton(
                            backgroundColor = if (status == "Pickup" || status == "Delivery") colorResource(
                                id = R.color.light_green2
                            ) else (colorResource(
                                id = R.color.red_1
                            )),
                            textPaddingVertical = 8.dp,
                            textPaddingHorizontal = 24.dp,
                            backgroundRadius = 4.dp,
                            textContent = status,
                            textSize = 12.sp,
                            textColor = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .background(colorResource(id = R.color.grey3))
                        .fillMaxWidth()
                        .height(2.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier
                            .weight(3f)
                    ) {
                        Text(
                            text = displayTextStart,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontFamily = montserrat,
                            fontSize = 16.sp,
                            style = TextStyle(fontWeight = FontWeight.ExtraBold),
                            color = colorResource(id = R.color.black),
                        )
                        Text(
                            text = date,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth(),
                            fontFamily = montserrat,
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.black),
                        )
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right),
                        contentDescription = "arrowRight",
                        modifier = Modifier
                            .padding(start = 4.dp, end = 12.dp)
                            .weight(3f)
                    )

                    Column(
                        modifier = Modifier
                            .weight(3f)
                    ) {
                        Text(
                            text = displayTextEnd,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontFamily = montserrat,
                            fontSize = 16.sp,
                            style = TextStyle(fontWeight = FontWeight.ExtraBold),
                            color = colorResource(id = R.color.black),
                        )
                        Text(
                            text = date,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            fontFamily = montserrat,
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.black),
                        )
                    }
                }

                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp)
                        .wrapContentHeight(),
                ) {

                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterStart),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_prof_aktif),
                            contentDescription = "profileicon",
                            modifier = Modifier
                                .size(48.dp)
                        )
                        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                            Text(
                                text = driverName,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                fontFamily = montserrat,
                                fontSize = 16.sp,
                                style = TextStyle(fontWeight = FontWeight.ExtraBold),
                                color = colorResource(id = R.color.black),
                            )
                            Text(
                                text = vehicleNumber,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp),
                                fontFamily = montserrat,
                                fontSize = 10.sp,
                                color = colorResource(id = R.color.black),
                            )
                        }
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    ) {
                        iconWithBackground(
                            imageIcon = painterResource(id = R.drawable.arrow_rightv2),
                            iconColor = Color.Unspecified,
                            backgroundColor = colorResource(
                                id = R.color.grey2
                            ),
                            backgroundRadius = 4.dp,
                            backgroundSize = 48.dp,
                            iconSize = 32.dp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun prehistory() {
    historyScreen()
}