package com.example.resikel.chatbot

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.resikel.R
import com.example.resikel.ui.theme.montserrat


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun chatScreen(navController: NavController, chatViewModel: ChatViewModel) {
    var userInput by remember { mutableStateOf("") }
    val listState = rememberLazyListState()

    // Meluncurkan efek untuk menggulir ke bawah saat ada pesan baru
    LaunchedEffect(chatViewModel.chatMessages.size) {
        listState.animateScrollToItem(chatViewModel.chatMessages.size)
    }

    // Gunakan Box untuk menumpuk elemen
    Box(modifier = Modifier.fillMaxSize()) {
        // Tambahkan gambar sebagai latar belakang
        Image(
            painter = painterResource(id = R.drawable.logo1), // Ganti dengan ID resource gambar Anda
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.8f)
                .padding(8.dp), // Kurangi ukuran efektif gambar
            contentScale = ContentScale.Fit // Memastikan gambar memenuhi seluruh layar
        )

        // Kolom utama di atas gambar
        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            TopAppBar(
                title = {
                    Text(
                        "AskResikel",
                        fontWeight = FontWeight.Bold,
                        fontFamily = montserrat
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )

            // List Pesan
            LazyColumn(
                state = listState, // Menghubungkan state dengan LazyColumn
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                items(chatViewModel.chatMessages) { chatMessage ->
                    ChatBubble(chatMessage)
                }

                // Tampilkan "sedang mengetik" jika isTyping true
                if (chatViewModel.isTyping) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Sedang mengetik...",
                                fontFamily = montserrat,
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }

            // Input Pesan
            BottomAppBar(containerColor = Color.Transparent) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = userInput,
                        onValueChange = { userInput = it },
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Ketik pesan...", color = Color.Gray) },
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(242, 243, 247),
                            unfocusedContainerColor = Color(242, 243, 247),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(27, 94, 60)
                        ),
                        onClick = {
                            if (userInput.isNotBlank()) {
                                chatViewModel.sendMessageToChatbot(userInput)
                                userInput = "" // Kosongkan input setelah dikirim
                            }
                        }) {
                        Text("Kirim", fontWeight = FontWeight.Bold, fontFamily = montserrat)
                    }
                }
            }
        }
    }
}

//component
@Composable
fun ChatBubble(chatMessage: ChatMessage) {
    val alignment = if (chatMessage.isUser) Alignment.End else Alignment.Start
    val bubbleColor =
        if (chatMessage.isUser) colorResource(R.color.main_green) else MaterialTheme.colorScheme.surface

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = if (chatMessage.isUser) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(bubbleColor, shape = RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            Text(
                text = chatMessage.message,
                color = if (chatMessage.isUser) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}



