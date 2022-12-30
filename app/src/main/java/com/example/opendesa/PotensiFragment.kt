package com.example.opendesa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [PotensiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PotensiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: PotensiAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var potensiArraylist: ArrayList<Potensi>

    lateinit var imageId: Array<Int>
    lateinit var ttlPotensi: ArrayList<String>
    lateinit var descPotensi: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_potensi, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PotensiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PotensiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.potensi_recycler)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter=PotensiAdapter(potensiArraylist)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){
        potensiArraylist = arrayListOf<Potensi>()
        imageId = arrayOf(
            R.drawable.duriankumpeh,
            R.drawable.dukukumpeh,
            R.drawable.kelapasawit,
            R.drawable.loji_belanda_muara_kumpeh_2,
            R.drawable.candi_sogo
        )

        ttlPotensi=  resources.getStringArray(R.array.potensi_title).toList() as ArrayList<String>
        descPotensi=  resources.getStringArray(R.array.potensi_desc).toList() as ArrayList<String>

        for (i in imageId.indices){
            val potensi = Potensi(imageId[i], ttlPotensi[i], descPotensi[i])
            potensiArraylist.add(potensi)
        }
    }
}