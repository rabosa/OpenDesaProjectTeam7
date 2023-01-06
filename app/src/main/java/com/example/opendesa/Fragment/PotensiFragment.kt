package com.example.opendesa.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.opendesa.Api.PotensiApi
import com.example.opendesa.Api.PotensiApiEndPoint
import com.example.opendesa.Data.Data


import com.example.opendesa.R
import com.example.opendesa.databinding.FragmentPotensiBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PotensiFragment : Fragment(R.layout.fragment_potensi) {

    private lateinit var binding: FragmentPotensiBinding
    //private val binding get() = _binding!!
    //var filteredPotensi: ArrayList<Data> = ArrayList<Data>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val potensiViewModel = ViewModelProvider(this).get(PotensiViewModel::class.java)
        //_binding = FragmentPotensiBinding.inflate(inflater, container, false)
        /*val root: View = binding.root
        val recyclerView = binding.potensiRecycler

        //button 1
        binding.potensiCat1.setOnClickListener{
            filterList("cat1")
            recyclerView.layoutManager = LinearLayoutManager(root.context)
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
        recyclerView.adapter = PotensiAdapter(root.context,PotensiData().LoadPotensi())*/
        getPotensiList()
        binding = FragmentPotensiBinding.inflate(layoutInflater)

        return binding.root

    }

    private fun getPotensiList() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = PotensiApi.getInstance().create(PotensiApiEndPoint::class.java).getPotensiData()

            withContext(Dispatchers.Main){
                binding.potensiRecycler.adapter = PotensiAdapter(requireContext(), res.body()!!.data)
            }

            Log.d("SHUBH", "getPotensiList: ${res.body()!!.data}")
        }
    }


    /*
    fun filterList(category: String = ""){
        filteredPotensi.clear()
        for(potensi in PotensiData().LoadPotensi()){
            if(potensi.kategori == category.lowercase()){
                filteredPotensi.add(potensi)
            }
        }
    }*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Potensi Desa"
    }

    /*
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

}