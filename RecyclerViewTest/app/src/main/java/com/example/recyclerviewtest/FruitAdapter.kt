package com.example.recyclerviewtest

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import java.security.AccessController.getContext

class FruitAdapter(val fruitList: List<Fruit>,val contextPrevious:Context) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            var intent= Intent(contextPrevious,ShowSingleImage::class.java)
            intent.putExtra("message",""+position)
            contextPrevious.startActivity(intent)
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            var intent= Intent(contextPrevious,ShowSingleImage::class.java)
            intent.putExtra("message",""+position)
            contextPrevious.startActivity(intent)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
//        holder.fruitImage.setImageResource(R.drawable.folder)
//        Glide.with(fruit.con).load(fruit.uri)
//            .into(holder.fruitImage)
                Glide.with(contextPrevious).load(fruit.uri)
            .into(holder.fruitImage)
        holder.fruitName.text = fruit.name
    }

    override fun getItemCount() = fruitList.size

}