package com.example.opendesa.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.opendesa.databinding.FragmentPotensiDetailBinding
import com.example.opendesa.ViewModel.PotensiViewModel
import com.example.opendesa.R


class PotensiDetailFragment : Fragment(R.layout.fragment_potensi_detail) {

    private var _binding: FragmentPotensiDetailBinding?=null
    private val binding get() = _binding!!
    private val args by navArgs<com.example.opendesa.Fragment.PotensiDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val detailViewModel = ViewModelProvider(this).get(PotensiViewModel::class.java)
        _binding = FragmentPotensiDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //binding.imagedesc.setImageResource(args.currentPotensi.potensiImage)
        binding.desctittle.text = args.currentPotensi.nama
        binding.fulldesc.text = args.currentPotensi.deskripsi
        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Detail Potensi"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}