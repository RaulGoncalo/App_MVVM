package com.rgos_developer.aulaapicommvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rgos_developer.aulaapicommvvm.R
import com.rgos_developer.aulaapicommvvm.databinding.ActivityMainBinding
import com.rgos_developer.aulaapicommvvm.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var postsViewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        postsViewModel = ViewModelProvider(this)[PostsViewModel::class.java]


        postsViewModel.listPosts.observe(this){posts ->
            var result = ""

            posts.forEach {
                result += "(${it.id}) ${it.title} \n"
            }

            binding.textResultado.text = result
        }

    }

    override fun onStart() {
        super.onStart()
        postsViewModel.getPosts()
    }
}