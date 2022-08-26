package com.mert.malkinfo.profilo.Siniflar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mert.malkinfo.profilo.R

class  UrunlerAdapter(private val newsList : ArrayList<Urunler>) : RecyclerView.Adapter<UrunlerAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_urunler,
            parent, false
        )

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = newsList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading
        holder.tvUcret.text = currentItem.ucret

    }

    override fun getItemCount(): Int {

        return newsList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
        val tvUcret: TextView = itemView.findViewById(R.id.tvUcret)


    }
}