package com.example.resikel.classification

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Multipart
    @POST("/predict")
    suspend fun classifyImage(
        @Header("API-Key") apiKey: String,
        @Part image: MultipartBody.Part
    ): Response<ImageClassificationResponse>
}

data class ImageClassificationResponse(
    val predicted_class: String,
    val confidence: String
)
