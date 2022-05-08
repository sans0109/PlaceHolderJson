package com.example.placeholderjson.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BaseUrl.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: UserApi by lazy {
            retrofit.create(UserApi::class.java)
        }
    }
}