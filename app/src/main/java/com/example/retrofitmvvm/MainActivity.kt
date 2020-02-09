package com.example.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.Repositary.MainRepo
import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.api.AuthListner
import com.example.retrofitmvvm.api.Intecepter
import com.example.retrofitmvvm.model.Dummy
import com.example.retrofitmvvm.model.NotiResponse
import com.example.retrofitmvvm.viewmodel.MainViewModel
import com.example.retrofitmvvm.viewmodel.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), AuthListner{

//    override val kodein by kodein()


//    val factory:MainViewModelFactory by instance()
    lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val network = Intecepter(this)
        val apiService = ApiService(network)
        val repo = MainRepo(apiService)
        val factory = MainViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        viewModel.authListner = this
    }

    override fun onResume() {
        super.onResume()

        viewModel.getNotiDetails()
    }

    override fun onStarted() {
        Log.d("test_123", "started: ")
    }

    override fun onSuccess(data: List<Dummy>) {
        Log.d("test_123", "pass: ${data.get(0).id}")
    }

    override fun onFailure(message: String?) {
        Log.d("test_123", "fail: ${message}")
    }

}
