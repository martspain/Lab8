package com.example.lab8.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab8.network.Github

class DetailViewModelFactory(
    private val gitHub: Github,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(gitHub, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}