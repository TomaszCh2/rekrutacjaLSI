package com.example.rekrutacjalsi

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rekrutacjalsi.database.User
import com.example.rekrutacjalsi.database.UserDatabase

import com.example.rekrutacjalsi.repositories.dailymotion.DailyMotionCalls
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var users = MutableLiveData<List<User>>()
    lateinit var db: UserDatabase

    fun onStart(context: Context) {
        db = UserDatabase.getInstance(context)

        viewModelScope.launch {
            val db = UserDatabase.getInstance(context)
            getDailyMotionUsers()
            getUsers()
        }
    }

    private suspend fun getDailyMotionUsers(){
        val response = DailyMotionCalls.service.getUsers()
        response.body()?.users?.map { user -> User(user.id, user.screenName, "", "") }.also {
            it?.let { db.userDao().insertAll(it) }
        }
    }

    private suspend fun getUsers(){
        try {
            users.value = db.userDao().getAll()
        } catch (e: java.lang.Exception) {
        }
    }
}