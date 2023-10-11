package com.example.myapplication.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.EachRowBinding
import com.example.myapplication.model.Post

class DataAdapter(private var postList: List<Post>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    inner class DataViewHolder(private val binding: EachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.post=item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = EachRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int = postList.size


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data=postList[position]
        holder.bind(data)

    }
}