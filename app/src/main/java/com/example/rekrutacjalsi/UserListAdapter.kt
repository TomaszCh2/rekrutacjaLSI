package com.example.rekrutacjalsi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rekrutacjalsi.database.User

class UserListAdapter(private val onClickListener: (User) -> Unit) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    var userList: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = userList[position].name
        holder.url.text = userList[position].url
        holder.itemView.setOnClickListener { view ->
            onClickListener.invoke(userList[position])
        }
    }

    override fun getItemCount(): Int = userList.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnail: ImageView
        val name: TextView
        val url: TextView

        init {
            name = view.findViewById(R.id.name)
            url = view.findViewById(R.id.url)
            thumbnail = view.findViewById(R.id.thumbnail)
        }
    }
}