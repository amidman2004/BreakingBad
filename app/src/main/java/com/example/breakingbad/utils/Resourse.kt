package com.example.breakingbad.utils

sealed class Resourse<T>(val response:T? = null,val error:String? = null) {
    class Success<T>(response: T):Resourse<T>(response = response)
    class Loading()
    class Error<T>(error: String):Resourse<T>(error = error)
}