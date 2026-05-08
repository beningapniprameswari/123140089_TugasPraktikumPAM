package com.example.tugaspam7.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
data class RemoteNote(
    val id: Int,
    val title: String,
    val body: String
)

class NoteApiService(private val client: HttpClient) {
    suspend fun fetchExternalNotes(): List<RemoteNote> {
        // Using a public placeholder API for demonstration
        return client.get("https://jsonplaceholder.typicode.com/posts?_limit=5").body()
    }
}
