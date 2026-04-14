package com.example.a6_123140089.data.api

import com.example.a6_123140089.data.model.NewsArticle
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getNews(): List<NewsArticle>
}
