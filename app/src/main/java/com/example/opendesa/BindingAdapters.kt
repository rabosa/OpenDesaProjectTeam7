package com.example.opendesa

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.opendesa.model.Berita
import com.example.opendesa.ui.home.BeritaAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Berita>?) {
    val adapter = recyclerView.adapter as BeritaAdapter
    adapter.submitList(data)
}