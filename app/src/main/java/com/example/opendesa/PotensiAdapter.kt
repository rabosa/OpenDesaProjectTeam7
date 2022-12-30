package com.example.opendesa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.imageview.ShapeableImageView

class PotensiAdapter(private val potensiList: ArrayList<Potensi>) :
    RecyclerView.Adapter<PotensiAdapter.PotensiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotensiViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_potensi,parent,false)
        return PotensiViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PotensiViewHolder, position: Int) {
        val currentItem = potensiList[position]
        holder.potensiImage.setImageResource(currentItem.potensiImage)
        holder.potensiTitle.text = currentItem.potensiTitle
        holder.potensiDesc.text = currentItem.potensiDesc
    }

    override fun getItemCount(): Int {
        return potensiList.size
    }

    class PotensiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val potensiImage: ShapeableImageView= itemView.findViewById(R.id.potensi_image)
        val potensiTitle: TextView= itemView.findViewById(R.id.potensiTitle)
        val potensiDesc: TextView= itemView.findViewById(R.id.potensiDesc)
    }
}