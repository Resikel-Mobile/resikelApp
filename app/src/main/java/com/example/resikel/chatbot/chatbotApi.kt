package com.example.resikel.chatbot

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChatbotApi {
    @Headers(
        "Content-Type: application/json",
        "API-Key: 499c18c6-9f57-45f8-b6eb-ba2c8275e274" // API Key ditambahkan di sini
    )
    @POST("chat")
    suspend fun sendMessage(
        @Body chatRequest: ChatRequest
    ): ChatResponse
}
