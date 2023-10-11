package com.example.myapplication.ui.adapter

import android.content.Context
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Post

@BindingAdapter("posts")
fun setPosts(recyclerView: RecyclerView, posts: List<Post>?) {
    val adapter = recyclerView.adapter as DataAdapter
}