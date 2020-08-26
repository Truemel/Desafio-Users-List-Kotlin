package com.example.desafiouserslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiouserslist.modelo.UserRetroRequest
import com.example.desafiouserslist.modelo.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<ArrayList<Users>> {

    lateinit var recView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recView = findViewById(R.id.recyclerV)
        recView.layoutManager = LinearLayoutManager(this)

        //aaa()

        loadAPI()
    }

    fun loadAPI(){
        var request:UserRetroRequest = UserRetroRequest()
        request.getUserListRequest(this)
    }

    override fun onResponse(call: Call<ArrayList<Users>>, response: Response<ArrayList<Users>>) {
        if(response != null){
            recView.adapter = UserListAdapter(response.body()!!)
        }
    }

    override fun onFailure(call: Call<ArrayList<Users>>, t: Throwable) {

    }

//    fun aaa(){
//        var retro:Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(
//            GsonConverterFactory.create()).build()
//        var call: Call<ArrayList<Users>> = retro.create(UserRetroCalls::class.java).getUserList()
//        call.enqueue(object :Callback<ArrayList<Users>>{
//            override fun onResponse(
//                call: Call<ArrayList<Users>>,
//                response: Response<ArrayList<Users>>
//            ) {
//                if(response != null){
//                    recView.adapter = UserListAdapter(response.body()!!)
//                }
//            }
//
//            override fun onFailure(call: Call<ArrayList<Users>>, t: Throwable) {
//
//            }
//        })
//    }
}