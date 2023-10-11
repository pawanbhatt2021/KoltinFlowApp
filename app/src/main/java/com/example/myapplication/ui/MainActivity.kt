package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.adapter.DataAdapter
import com.example.myapplication.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var dataAdapter: DataAdapter
    private lateinit var dataViewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataViewModel = ViewModelProvider(this)[DataViewModel::class.java]
        dataViewModel.getPost()
        dataViewModel.responseLiveData.observe(this) {
            dataAdapter = DataAdapter(it)
            binding?.rvData?.apply {
                setHasFixedSize(true)
                adapter = dataAdapter
                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            }
            binding?.progressBar?.visibility = View.GONE
            binding?.rvData?.visibility = View.VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}