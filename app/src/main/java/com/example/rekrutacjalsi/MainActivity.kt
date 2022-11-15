package com.example.rekrutacjalsi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rekrutacjalsi.database.User
import com.example.rekrutacjalsi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var adapter = UserListAdapter(onClickListener = { user -> openActivity(user) })

    private val userObserver = Observer<List<User>> {
        adapter.userList = it
        adapter.notifyDataSetChanged()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart(this)
        viewModel.users.observe(this, userObserver)
    }

    fun openActivity(user: User) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra("userId", user.id)
        startActivity(intent)
    }
}