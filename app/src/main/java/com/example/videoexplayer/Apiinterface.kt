package com.example.videoexplayer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiinterface {

    @GET("videos/")
    fun getvideo(
        @Query("key") apiKey: String,
        @Query("q") query: String,
        @Query("pretty") pretty: Boolean
//        @Query("q")
//        searchQuery: String,
//        @Query("page")
//        pageNumber: Int = 1,
//        @Query("apiKey")
//        apiKey: String = "32559111-25b5b9eda08194742d3e05e1c"
    ): Call<video>
}

//suspend fun getBreakingNews(
//    @Query("q")
//    searchQuery: String,
//    @Query("page")
//    pageNumber:Int=1,
//    @Query("apiKey")
//    apiKey:String=API_KEY