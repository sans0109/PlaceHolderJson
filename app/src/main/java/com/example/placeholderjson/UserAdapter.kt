package com.example.placeholderjson

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placeholderjson.models.Root

class UserAdapter(var context: Context, var userList: ArrayList<Root>)
    : RecyclerView.Adapter<UserAdapter.UserHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val list = userList[position]
        holder.id.text = list.id.toString()
        holder.name.text = list.name
        holder.city.text = list.address.city
        holder.code.text = list.address.zipcode
        holder.cname.text = list.company.name
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setUserData(userList: ArrayList<Root>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val id: TextView = itemView.findViewById(R.id.tv_id)
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val city: TextView = itemView.findViewById(R.id.tv_city)
        val code: TextView = itemView.findViewById(R.id.tv_zipcode)
        val cname: TextView = itemView.findViewById(R.id.tv_company)
    }
}