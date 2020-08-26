package com.example.desafiouserslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiouserslist.modelo.Users

class UserListAdapter(var list:ArrayList<Users>):RecyclerView.Adapter<UserListAdapter.Holder>() {


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var name:TextView
        lateinit var email:TextView
        lateinit var phone:TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.users_list_item,parent, false)
        var holder:Holder = Holder(view)
        holder.name = view.findViewById(R.id.name)
        holder.email = view.findViewById(R.id.email)
        holder.phone = view.findViewById(R.id.phone)

        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = list.get(position).name.toString()
        holder.phone.text = list.get(position).phone.toString()
        holder.email.text = list.get(position).email.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

}