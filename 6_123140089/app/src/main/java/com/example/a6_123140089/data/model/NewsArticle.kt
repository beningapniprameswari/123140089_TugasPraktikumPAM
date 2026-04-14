package com.example.a6_123140089.data.model

import com.google.gson.annotations.SerializedName

data class NewsArticle(
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val description: String,
    val imageUrl: String = "https://picsum.photos/seed/${id}/400/300"
)
