package com.rgos_developer.aulaapicommvvm.api

import com.rgos_developer.aulaapicommvvm.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceApi {

    @GET("posts")
    suspend fun getPosts() : Response<List<PostModel>>
}