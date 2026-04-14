package com.example.a6_123140089.data.repository

import com.example.a6_123140089.data.api.ApiService
import com.example.a6_123140089.data.model.NewsArticle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {
    private val apiService: ApiService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun getNews(): List<NewsArticle> {
        return apiService.getNews()
    }
}
