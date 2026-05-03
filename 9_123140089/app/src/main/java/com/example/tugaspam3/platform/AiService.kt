package com.example.tugaspam3.platform

import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface AiService {
    suspend fun summarizeNote(content: String): String
    suspend fun fixGrammar(content: String): String
    fun streamAiResponse(prompt: String): Flow<String>
}

class GeminiAiService(private val apiKey: String) : AiService {
    
    // Menggunakan gemini-2.0-flash-exp (Model Generasi Terbaru)
    // Pastikan API Key Anda aktif dan memiliki akses ke Gemini 2.0 di Google AI Studio
    private val model = GenerativeModel(
        modelName = "gemini-2.0-flash-exp",
        apiKey = apiKey
    )

    override suspend fun summarizeNote(content: String): String {
        return try {
            val response = model.generateContent("Buat ringkasan teks ini dalam poin-poin:\n\n$content")
            response.text ?: "Gagal membuat ringkasan."
        } catch (e: Exception) {
            "Error: ${e.localizedMessage}. Pastikan kunci API dan nama model benar."
        }
    }

    override suspend fun fixGrammar(content: String): String {
        return try {
            val response = model.generateContent("Perbaiki grammar teks ini (hanya teks hasilnya saja):\n\n$content")
            response.text ?: content
        } catch (e: Exception) {
            "Error: ${e.localizedMessage}"
        }
    }

    override fun streamAiResponse(prompt: String): Flow<String> = flow {
        try {
            model.generateContentStream(prompt).collect { chunk ->
                chunk.text?.let { emit(it) }
            }
        } catch (e: Exception) {
            emit("Error: ${e.localizedMessage}")
        }
    }
}
