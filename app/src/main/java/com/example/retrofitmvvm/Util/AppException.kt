package com.example.retrofitmvvm.Util

import java.io.IOException

class AppException(message:String) : IOException(message)
class NetworkException(message:String) : IOException(message)