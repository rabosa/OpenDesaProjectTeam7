package com.example.opendesa.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.opendesa.Potensi
import com.example.opendesa.R
import com.google.android.material.imageview.ShapeableImageView

class PotensiAdapter(private val context: Context, private val potensiList: List<Potensi>) :
    RecyclerView.Adapter<PotensiAdapter.PotensiViewHolder>() {

    class PotensiViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val potensiImage: ShapeableImageView= itemView.findViewById(R.id.potensi_image)
        val potensiTitle: TextView= itemView.findViewById(R.id.potensiTitle)
        val potensiDesc: TextView= itemView.findViewById(R.id.potensiDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotensiViewHolder {
        val ItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_potensi,parent,false)

        return PotensiViewHolder(ItemView)
    }


    override fun onBindViewHolder(holder: PotensiViewHolder, position: Int) {
        val currentItem = potensiList[position]
        holder.potensiImage.setImageResource(currentItem.potensiImage)
        holder.potensiTitle.text = currentItem.potensiTitle
        holder.potensiDesc.text = currentItem.potensiDesc
        holder.itemView.setOnClickListener { view ->
            val action = PotensiFragmentDirections.actionPotensiFragmentToPotensiDetailFragment(currentItem)
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return potensiList.size
    }
}