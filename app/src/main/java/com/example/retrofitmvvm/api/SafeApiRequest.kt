package com.example.retrofitmvvm.api

import android.util.Log
import com.example.retrofitmvvm.Util.AppException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SafeApiRequest {

    suspend fun<T : Any> apiRequest(call : suspend () -> Response<T>) : T {
        val response = call.invoke()

        Log.d("test_123", "response: ${response.isSuccessful}")

        if (response.isSuccessful) {
            return response.body()!!
        }else {
            val error = response.errorBody()?.string()

            val message = StringBuilder()
            error.let {
                try {
                    message.append(JSONObject(it!!).getString("message"))
                }catch (e: JSONException) {}
                message.append("\n")
            }
            message.append("Error code: ${response.code()}")
            throw AppException(message.toString())
        }
    }
}