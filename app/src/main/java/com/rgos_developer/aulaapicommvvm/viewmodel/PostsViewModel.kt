package com.rgos_developer.aulaapicommvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rgos_developer.aulaapicommvvm.model.PostModel
import com.rgos_developer.aulaapicommvvm.model.PostsApi
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {

    val listPosts = MutableLiveData<List<PostModel>>()

    fun getPosts() {
        val postsApi = PostsApi()
        viewModelScope.launch {
            val posts = postsApi.getPosts()
            listPosts.postValue(posts)
        }

    }

}