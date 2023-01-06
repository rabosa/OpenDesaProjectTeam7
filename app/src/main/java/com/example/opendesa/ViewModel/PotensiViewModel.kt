package com.example.opendesa.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.opendesa.Data.PotensiData

class PotensiViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val myDataset = PotensiData().LoadPotensi()
}