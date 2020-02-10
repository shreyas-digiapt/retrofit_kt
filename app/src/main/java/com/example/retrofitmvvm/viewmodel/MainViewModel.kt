package com.example.retrofitmvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.retrofitmvvm.Repositary.MainRepo
import com.example.retrofitmvvm.Util.AppException
import com.example.retrofitmvvm.Util.Coroutines
import com.example.retrofitmvvm.Util.NetworkException
import com.example.retrofitmvvm.api.AuthListner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepo: MainRepo): ViewModel() {

    var authListner:AuthListner? = null

   fun getNotiDetails() {
       authListner?.onStarted()

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val getNotiDetails =  mainRepo.getNotiDetails()
                authListner?.onSuccess(getNotiDetails)
            }catch (e:AppException) {
                authListner?.onFailure(e.message)
            }catch (e: NetworkException) {
                authListner?.onFailure(e.message)
            }
        }
   }
}