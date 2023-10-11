package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Post
import com.example.myapplication.repository.DataRepository
import com.example.myapplication.ui.adapter.DataAdapter
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DataViewModel :ViewModel() {
    val responseLiveData = MutableLiveData<List<Post>>()

    fun getItems(): LiveData<List<Post>> {
        return responseLiveData
    }
    fun getPost(){
        viewModelScope.launch {
            DataRepository.getPost().catch {e->
                Log.d("MainData","Post : ${e.message}")
            }.collect{response->
                responseLiveData.value=response
            }
        }
    }
}