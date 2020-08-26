package com.example.desafiouserslist.modelo

import retrofit2.Call
import retrofit2.http.GET

interface UserRetroCalls {
    @GET("users")
    fun getUserList(): Call<ArrayList<Users>>
}