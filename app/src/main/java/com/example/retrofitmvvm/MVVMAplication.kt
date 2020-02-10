package com.example.retrofitmvvm

import android.app.Application
import com.example.retrofitmvvm.Repositary.MainRepo
import com.example.retrofitmvvm.api.ApiService
import com.example.retrofitmvvm.api.Intecepter
import com.example.retrofitmvvm.viewmodel.MainViewModel
import com.example.retrofitmvvm.viewmodel.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMAplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMAplication))

        bind() from singleton { Intecepter(instance()) }
//        bind() from singleton { ApiService(instance()) }
        bind() from singleton { MainRepo(instance()) }
        bind() from provider { MainViewModelFactory(instance()) }

    }



}