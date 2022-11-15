package com.example.rekrutacjalsi

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rekrutacjalsi.database.User
import com.example.rekrutacjalsi.database.UserDatabase
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() {

    var user = MutableLiveData<User>()
    lateinit var db: UserDatabase

    fun onStart(context: Context, userId: String?) {
        userId?.let {
            db = UserDatabase.getInstance(context)
            viewModelScope.launch {
                getUser(userId)
            }
        }
    }

    private suspend fun getUser(userId: String){
        try {
            user.value = db.userDao().getUser(userId)
        } catch (e: java.lang.Exception) {
        }
    }
}