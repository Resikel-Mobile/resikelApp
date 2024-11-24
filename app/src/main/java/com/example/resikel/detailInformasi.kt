package com.example.resikel

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun detailInformasi(modifier: Modifier = Modifier) {
    Text("hello detail")
}

@Preview
@Composable
private fun predetailInformasi() {
    detailInformasi()
}