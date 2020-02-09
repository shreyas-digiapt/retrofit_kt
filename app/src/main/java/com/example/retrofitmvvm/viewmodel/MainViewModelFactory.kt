package com.example.retrofitmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.Repositary.MainRepo

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val mainRepo: MainRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepo) as T
    }
}