package com.example.resikel.point

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.R
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.montserrat
import com.example.resikel.ui.theme.primaryGreen

@Composable
fun TransferSuccess(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Tukar Poin Berhasil",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = primaryGreen
        )
        Image(
            painterResource(R.drawable.ic_successful),
            contentDescription = null,
            modifier = Modifier.size(240.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            enabled = true,
            onClick = {
                //go to home
            }) {
            Text(
                text = "Kembali Ke halaman Utama",
                fontWeight = FontWeight.Bold,
                color = primaryGreen,
                fontFamily = montserrat,
                fontSize = 16.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TransferSuccessPreview() {
    ResikelTheme {
        TransferSuccess()
    }

}