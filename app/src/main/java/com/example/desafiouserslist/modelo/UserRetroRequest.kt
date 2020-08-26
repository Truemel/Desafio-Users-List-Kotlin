package com.example.desafiouserslist.modelo

import retrofit2.Call
import retrofit2.Callback

class UserRetroRequest {

    private var userCalls:UserRetroCalls? = null

    init {
        userCalls = UserRetrofit.getRetro().create(UserRetroCalls::class.java)
    }

    fun getUserListRequest(callB: Callback<ArrayList<Users>>){
        var call: Call<ArrayList<Users>> = userCalls!!.getUserList()
        call.enqueue(callB)
    }
}