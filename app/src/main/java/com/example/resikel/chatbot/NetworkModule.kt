package com.example.resikel.chatbot

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "https://application-14.1ot74bbkopyr.us-south.codeengine.appdomain.cloud/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val chatbotApi: ChatbotApi = retrofit.create(ChatbotApi::class.java)
}
