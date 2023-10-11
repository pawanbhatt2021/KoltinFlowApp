package com.example.myapplication.repository

import com.example.myapplication.model.Post
import com.example.myapplication.retrofit.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DataRepository {
    companion object{
        fun getPost():Flow<List<Post>> = flow {
            val post = RetrofitBuilder.apiService.getPost()
            emit(post)
        }.flowOn(Dispatchers.IO)
    }
}