package com.example.rv.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rv.R
import com.example.rv.model.Item


class Adapter_top(val context:Context, val list:List<Item>): RecyclerView.Adapter<Adapter_top.ViewHolder>() {
    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        val image:ImageView=itemView.findViewById(R.id.itemImage)
        val name:TextView=itemView.findViewById(R.id.itemName)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view:View=LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=list[position]
        holder.name.text=item.imageName
        holder.image.setImageResource(item.imageId)
    }


    override fun getItemCount(): Int {
       return list.size
    }
}