package com.example.opendesa.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.opendesa.Data.PotensiData
import com.example.opendesa.Potensi
import com.example.opendesa.R
import com.example.opendesa.databinding.FragmentPotensiBinding
import java.util.ArrayList


class PotensiFragment : Fragment(R.layout.fragment_potensi) {

    private var _binding: FragmentPotensiBinding? = null
    private val binding get() = _binding!!
    var filteredPotensi: ArrayList<Potensi> = ArrayList<Potensi>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val potensiViewModel = ViewModelProvider(this).get(PotensiViewModel::class.java)
        _binding = FragmentPotensiBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView = binding.potensiRecycler


        //button 1
        binding.potensiCat1.setOnClickListener{
            filterList("cat1")
            recyclerView.layoutManager =LinearLayoutManager(root.context)
            recyclerView.adapter = PotensiAdapter(root.context,filteredPotensi)
            //Toast.makeText(activity, "Filter Cat 1", Toast.LENGTH_SHORT).show()
        }
        //button 1
        binding.potensiCat2.setOnClickListener{
            filterList("cat2")
            recyclerView.layoutManager =LinearLayoutManager(root.context)
            recyclerView.adapter = PotensiAdapter(root.context,filteredPotensi)
            //Toast.makeText(activity, "Filter Cat 2", Toast.LENGTH_SHORT).show()
        }
        //button 1
        binding.potensiCat3.setOnClickListener{
            filterList("cat3")
            recyclerView.layoutManager =LinearLayoutManager(root.context)
            recyclerView.adapter = PotensiAdapter(root.context,filteredPotensi)
            //Toast.makeText(activity, "Filter Cat 3", Toast.LENGTH_SHORT).show()
        }
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =LinearLayoutManager(root.context)
        recyclerView.adapter = PotensiAdapter(root.context, PotensiData().LoadPotensi())
        return root

    }


    fun filterList(category: String = ""){
        filteredPotensi.clear()
        for(potensi in PotensiData().LoadPotensi()){
            if(potensi.potensiCat == category.lowercase()){
                filteredPotensi.add(potensi)
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Potensi Desa"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}