package com.example.resikel.chatbot

data class ChatRequest(
    val message: String
)

data class ChatResponse(
    val response: String
)

data class ChatMessage(
    val message: String,
    val isUser: Boolean // true jika pesan dari pengguna, false jika dari chatbot
)