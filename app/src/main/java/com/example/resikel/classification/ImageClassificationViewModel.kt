package com.example.resikel.classification

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class ImageClassificationViewModel : ViewModel() {

    fun classifyImage(imageFile: File, onResult: (Pair<String, String>) -> Unit) {
        viewModelScope.launch {
            val apiKey = "499c18c6-9f57-45f8-b6eb-ba2c8275e274"

            // Convert File to MultipartBody.Part
            val requestBody = RequestBody.create("image/*".toMediaTypeOrNull(), imageFile)
            val multipartBody = MultipartBody.Part.createFormData("file", imageFile.name, requestBody)

            try {
                val response = RetrofitClient.instance.classifyImage(apiKey, multipartBody)
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {
                        onResult(Pair(result.predicted_class, result.confidence))
                    }
                } else {
                    Log.e("ImageClassification", "Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("ImageClassification", "Exception: ${e.message}")
            }
        }
    }
}
