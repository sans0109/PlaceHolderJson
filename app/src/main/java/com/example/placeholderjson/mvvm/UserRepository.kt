package com.example.placeholderjson.mvvm

import com.example.placeholderjson.models.Root
import com.example.placeholderjson.retrofit.RetrofitBuilder

class UserRepository {
    suspend fun getUser() : List<Root> =
        RetrofitBuilder.api.getAllUsers()
}