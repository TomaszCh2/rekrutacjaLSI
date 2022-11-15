package com.example.rekrutacjalsi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rekrutacjalsi.database.User
import com.example.rekrutacjalsi.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    private var userId: String? = null

    private val userObserver = Observer<User> {
        binding.name.text = it.name
        binding.url.text = it.url
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras
        userId = extras?.getString("userId")
    }

    override fun onStart() {
        super.onStart()
        viewModel.user.observe(this, userObserver)
        viewModel.onStart(this, userId)
    }

}