package com.example.desafiouserslist.modelo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRetrofit() {

    companion object{
        private const val BASE_URL:String = "https://jsonplaceholder.typicode.com/"

        private var userRetrofit:Retrofit? = null

        fun getRetro():Retrofit{
            if(userRetrofit == null)
                synchronized(this){
                    userRetrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
                }

            return userRetrofit!!
        }
    }
}