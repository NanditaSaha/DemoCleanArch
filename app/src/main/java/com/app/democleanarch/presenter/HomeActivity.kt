package com.app.democleanarch.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.democleanarch.R
import com.app.democleanarch.databinding.ActivityHomeBinding
import com.app.democleanarch.presenter.adapter.UserListAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.mutableList.observe(this, Observer { newText ->

            val adapter = UserListAdapter(newText)
            binding.recyclerview.adapter = adapter

        })
    }
}