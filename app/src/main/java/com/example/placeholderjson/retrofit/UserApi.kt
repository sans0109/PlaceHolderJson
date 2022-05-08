package com.example.placeholderjson.retrofit

import com.example.placeholderjson.models.Root
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getAllUsers() : List<Root>
}