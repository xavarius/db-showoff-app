package com.maciejmalak.dbdemo

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maciejmalak.dbdemo.UserAdapter.UserViewHolder

data class User(val name: String, val surname: String)

class UserAdapter(private val users: List<User>, private val onClick: (User) -> Unit) :
    RecyclerView.Adapter<UserViewHolder>() {

    class UserViewHolder(itemView: View, onClick: (User) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private var user: User? = null
        private val nameTextView: TextView = itemView.findViewById(R.id.nameSurname)

        init {
            itemView.setOnClickListener { user?.let(onClick) }
        }

        fun bind(user: User) {
            this.user = user
            "${user.name} ${user.surname}".also { nameTextView.text = it }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(users[position])


    override fun getItemCount(): Int = users.size
}
