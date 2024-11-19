package com.example.resikel

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun historyScreen(modifier: Modifier = Modifier) {
    Text("Hello history")
}

@Preview
@Composable
private fun prehistory() {
    historyScreen()
}