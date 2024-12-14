package com.example.resikel.classification

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toFile
import java.io.File

@Composable
fun classificationScreen(modifier: Modifier = Modifier,viewModel: ImageClassificationViewModel = viewModel()) {
    // State for image URI and classification result
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var classificationResult by remember { mutableStateOf<Pair<String, String>?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        selectedImageUri = uri
        classificationResult = null // Reset result when a new image is selected
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Button to select image
        Button(onClick = { launcher.launch("image/*") }) {
            Text(text = "Select Image")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display selected image
        selectedImageUri?.let { uri ->
            val context = LocalContext.current
            val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Selected Image",
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button to classify image
            Button(onClick = {
                val imageFile = File(getPathFromUri(context, uri))
                viewModel.classifyImage(imageFile) { result ->
                    classificationResult = result
                }
            }) {
                Text(text = "Classify Image")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display classification result
        classificationResult?.let { (predictedClass, confidence) ->
            Text(text = "Predicted Class: $predictedClass", )
            Text(text = "Confidence: $confidence", )
        }
    }
}

// Function to get the file path from a URI
fun getPathFromUri(context: Context, uri: Uri): String {
    val cursor = context.contentResolver.query(uri, null, null, null, null)
    cursor?.moveToFirst()
    val index = cursor?.getColumnIndex(MediaStore.Images.Media.DATA)
    val path = index?.let { cursor.getString(it) }
    cursor?.close()
    return path ?: throw IllegalArgumentException("Invalid URI")
}