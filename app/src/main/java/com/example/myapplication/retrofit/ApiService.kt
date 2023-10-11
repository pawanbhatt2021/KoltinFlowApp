package com.example.myapplication.retrofit

import com.example.myapplication.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPost(): List<Post>
}