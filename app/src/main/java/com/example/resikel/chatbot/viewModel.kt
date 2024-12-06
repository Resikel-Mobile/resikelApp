package com.example.resikel.chatbot

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val chatbotApi = NetworkModule.chatbotApi
    var isTyping by mutableStateOf(false)
        private set

    val chatMessages = mutableStateListOf<ChatMessage>() // Daftar untuk menyimpan riwayat chat

    fun sendMessageToChatbot(message: String) {
        // Tambahkan pesan pengguna ke daftar
        chatMessages.add(ChatMessage(message, isUser = true))

        // Tampilkan status sedang mengetik
        isTyping = true

        viewModelScope.launch {
            delay(2000) // 2 detik delay untuk simulasi sedang mengetik
            isTyping = false
            try {
                val response = chatbotApi.sendMessage(ChatRequest(message))
                // Tambahkan respons chatbot ke daftar
                chatMessages.add(ChatMessage(response.response, isUser = false))
            } catch (e: Exception) {
                // Tambahkan pesan error ke daftar
                chatMessages.add(ChatMessage("Error: ${e.localizedMessage}", isUser = false))
            }
        }
    }
}