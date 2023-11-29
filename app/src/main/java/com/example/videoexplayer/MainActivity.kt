package com.example.videoexplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: VideoAdpter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bind
        recyclerView = findViewById(R.id.rvView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://pixabay.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apiinterface::class.java)

        val retrofitdata =
            retrofitBuilder.getvideo("32559111-25b5b9eda08194742d3e05e1c", "yellow flowers", true)

        retrofitdata.enqueue(object : Callback<video?> {
            override fun onResponse(call: Call<video?>, response: Response<video?>) {
                val responsebody = response.body()
                val pdlist = responsebody?.hits!!

                myAdapter = VideoAdpter(this@MainActivity, pdlist)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
//               val tv=findViewById<TextView>(R.id.tvview)
//                tv.text=cd

            override fun onFailure(call: Call<video?>, t: Throwable) {
                Log.d("Activity", "onFailure" + t.message)
            }
        })

    }
}