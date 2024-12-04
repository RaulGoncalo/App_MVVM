package com.rgos_developer.aulaapicommvvm.model

import android.util.Log
import android.widget.Toast
import com.rgos_developer.aulaapicommvvm.api.RetrofitService

class PostsApi {

    suspend fun getPosts() : List<PostModel> {
        val jsonPlaceApi = RetrofitService.getJsonPlace()
        try {
            val res = jsonPlaceApi.getPosts()

            if(res.isSuccessful){
                res.body()?.let {posts ->
                    return posts
                }
            }
        }catch (error: Exception){
            error.printStackTrace()
        }

        return emptyList()
    }
}