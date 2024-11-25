package com.example.resikel

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.resikel.ui.theme.montserrat


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun detailInformasi(modifier: Modifier = Modifier, navController: NavController) {
    val interactionSource = remember { MutableInteractionSource() }
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.white))
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 6.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier

                            .size(56.dp)
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .background(
                                color = colorResource(R.color.main_green),
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
                            tint = colorResource(R.color.white)
                        )
                    }
                    Text(
                        "Detail Information",
                        fontSize = 20.sp,
                        color = colorResource(R.color.main_green),
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

        contentDetailInformasi()
    }
}

@Composable
fun contentDetailInformasi(modifier: Modifier = Modifier) {
    Surface(
        color = colorResource(R.color.white),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .offset(y = 94.dp)
            .padding(18.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                "Atasi sampah dibatam, DLH ajak masyarakat Pilah sampah.",
                fontFamily = montserrat,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 18.sp,
            )
            Spacer(Modifier.height(10.dp))
            Image(
                painter = painterResource(R.drawable.contethome),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(210.dp)
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(10.dp))
            Text(
                "Dinas Lingkungan Hidup (DLH) Kota Batam mengajak seluruh masyarakat untuk aktif berpartisipasi dalam pengelolaan sampah dengan cara memilah sampah sejak dari rumah. Langkah ini bertujuan untuk mengurangi volume sampah yang berakhir di TPA serta mendukung upaya daur ulang yang lebih efektif. Dengan memilah sampah organik, anorganik, dan bahan yang dapat didaur ulang, masyarakat dapat berkontribusi langsung dalam menjaga kebersihan lingkungan dan mewujudkan Batam yang lebih hijau dan berkelanjutan. Ayo, mulai pilah sampah dari sekarang demi masa depan yang lebih baik!",
                fontFamily = montserrat,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 18.sp,
            )
            Spacer(Modifier.height(40.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(27, 94, 60)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                onClick = { }) {
                Text(
                    text = "Learn More",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = montserrat,
                    fontSize = 16.sp,
                )
            }
        }

    }
}

@Preview
@Composable
private fun predetailInformasi() {
    detailInformasi(navController = rememberNavController())
}