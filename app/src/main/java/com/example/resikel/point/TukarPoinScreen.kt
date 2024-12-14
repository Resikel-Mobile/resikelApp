package com.example.resikel.point

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.resikel.R
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.montserrat
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TukarPoinScreen(modifier: Modifier = Modifier) {
    val showDialog = remember { mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Tukar Poin",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Box(
                        modifier = Modifier
                            .background(color = primaryGreen, CircleShape)
                            .padding(8.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            tint = primaryWhite
                        )
                    }

                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = primaryWhite,
                titleContentColor = primaryGreen,
//                navigationIconContentColor = primaryWhite
            )
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = primaryWhite)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //gopay
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = primaryWhite),
                elevation = CardDefaults.cardElevation(10.dp),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Image(
                            painterResource(R.drawable.ic_gopay),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        ) {
                            Text("Gopay", fontWeight = FontWeight.Bold)
                            Text("Milo = 0888472009", color = Color.Gray)
                        }
                        Image(
                            painterResource(R.drawable.ic_phone_book),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )

                    }
                    Text(
                        "Koin yang kamu punya 20",
                        color = Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                            .border(1.dp, Color.Green, shape = RoundedCornerShape(12.dp))
                            .padding(4.dp)
                    )
                }
            }
            //pilih nominal
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = primaryWhite),
                elevation = CardDefaults.cardElevation(10.dp),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text("Masukan Nominal", fontWeight = FontWeight.Bold)
                    }
                    OutlinedTextField(
                        placeholder = { Text("10000", color = Color.Gray) },
                        value = "",
                        shape = RoundedCornerShape(15.dp),
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Pilih Nominal", fontWeight = FontWeight.Bold)
                    //card row 1
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                                .border(
                                    BorderStroke(1.dp, Color.Gray),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            colors = CardDefaults.cardColors(containerColor = primaryWhite),
                            elevation = CardDefaults.cardElevation(10.dp),
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        top = 16.dp,
                                        end = 16.dp
                                    )
                                ) {
                                    Image(
                                        painterResource(R.drawable.ic_gopay),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text("Gopay", fontWeight = FontWeight.Bold)
                                }
                                Text(
                                    "10 Poin",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            1.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Text("Rp 10000", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                        //card
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                                .border(
                                    BorderStroke(1.dp, Color.Gray),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            colors = CardDefaults.cardColors(containerColor = primaryWhite),
                            elevation = CardDefaults.cardElevation(10.dp),
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        top = 16.dp,
                                        end = 16.dp
                                    )
                                ) {
                                    Image(
                                        painterResource(R.drawable.ic_gopay),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text("Gopay", fontWeight = FontWeight.Bold)
                                }
                                Text(
                                    "20 Poin",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            1.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Text("Rp 20000", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                    }
                    //card row 2
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                                .border(
                                    BorderStroke(1.dp, Color.Gray),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            colors = CardDefaults.cardColors(containerColor = primaryWhite),
                            elevation = CardDefaults.cardElevation(10.dp),
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        top = 16.dp,
                                        end = 16.dp
                                    )
                                ) {
                                    Image(
                                        painterResource(R.drawable.ic_gopay),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text("Gopay", fontWeight = FontWeight.Bold)
                                }
                                Text(
                                    "30 Poin",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            1.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Text("Rp 30000", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                        //card
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                                .border(
                                    BorderStroke(1.dp, Color.Gray),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            colors = CardDefaults.cardColors(containerColor = primaryWhite),
                            elevation = CardDefaults.cardElevation(10.dp),
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        top = 16.dp,
                                        end = 16.dp
                                    )
                                ) {
                                    Image(
                                        painterResource(R.drawable.ic_gopay),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text("Gopay", fontWeight = FontWeight.Bold)
                                }
                                Text(
                                    "40 Poin",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            1.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Text("Rp 40000", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                    }
                    //card row 3
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                                .border(
                                    BorderStroke(1.dp, Color.Gray),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            colors = CardDefaults.cardColors(containerColor = primaryWhite),
                            elevation = CardDefaults.cardElevation(10.dp),
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        top = 16.dp,
                                        end = 16.dp
                                    )
                                ) {
                                    Image(
                                        painterResource(R.drawable.ic_gopay),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text("Gopay", fontWeight = FontWeight.Bold)
                                }
                                Text(
                                    "50 Poin",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            1.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Text("Rp 50000", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                        //card
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                                .border(
                                    BorderStroke(1.dp, Color.Gray),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            colors = CardDefaults.cardColors(containerColor = primaryWhite),
                            elevation = CardDefaults.cardElevation(10.dp),
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        top = 16.dp,
                                        end = 16.dp
                                    )
                                ) {
                                    Image(
                                        painterResource(R.drawable.ic_gopay),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Text("Gopay", fontWeight = FontWeight.Bold)
                                }
                                Text(
                                    "60 Poin",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            1.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Text("Rp 60000", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                    }

                }
            }
            //tukar button
            Box(modifier = Modifier
                .padding(end = 16.dp, bottom = 16.dp)
                .align(Alignment.End)) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryGreen
                    ),
                    enabled = true,
                    onClick = { showDialog.value = true }) {
                    Text(
                        text = "Tukar",
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontFamily = montserrat,
                        fontSize = 16.sp,
                    )
                }
            }
        }
        if (showDialog.value) {
            Dialog(onDismissRequest = { showDialog.value = false }) {
                TransferSuccess()
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun TukarPoinScreenPreview() {
    ResikelTheme {
        TukarPoinScreen()

    }
}