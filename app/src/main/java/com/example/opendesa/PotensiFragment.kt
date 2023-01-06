package com.example.opendesa

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.opendesa.databinding.FragmentPotensiBinding
import kotlinx.coroutines.Dispatchers.Main


class PotensiFragment : Fragment(R.layout.fragment_potensi) {

    private var _binding: FragmentPotensiBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val potensiViewModel = ViewModelProvider(this).get(PotensiViewModel::class.java)
        _binding = FragmentPotensiBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView = binding.potensiRecycler
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =LinearLayoutManager(root.context)
        recyclerView.adapter=PotensiAdapter(root.context,potensiViewModel.myDataset)
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}