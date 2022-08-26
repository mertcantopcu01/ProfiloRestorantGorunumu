package com.mert.malkinfo.profilo.Siniflar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mert.malkinfo.profilo.R


class MyAdapter(private val userList : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var Mlistener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)

    }
    fun setOnItemClickListener(listener: onItemClickListener){
        Mlistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item,
            parent,false)
        return MyViewHolder(itemView,Mlistener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]
        holder.NO.text = currentitem.FaturaNo.toString()
        holder.OdenmeSekli.text = currentitem.OdenmeSekli.toString()
        holder.Tutar.text = currentitem.Tutar.toString()

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView :View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val NO : TextView = itemView.findViewById(R.id.tvNO)
        val OdenmeSekli : TextView = itemView.findViewById(R.id.tvOdenmeSekli)
        val Tutar : TextView = itemView.findViewById(R.id.tvTutar)
        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }
}