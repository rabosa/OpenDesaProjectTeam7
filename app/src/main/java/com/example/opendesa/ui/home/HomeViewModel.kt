package com.example.opendesa.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.opendesa.model.Berita
import com.example.opendesa.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {
    private val _berita = MutableLiveData<List<Berita>>()
    val berita : LiveData<List<Berita>> = _berita

    fun getBeritaKecamatan() {
        viewModelScope.launch {
            val response: List<List<Berita>> = repository.getBerita()
            val listBerita = mutableListOf<Berita>()
            for (i in 0..2){
                listBerita.add(response[0][i])
            }
            _berita.value = listBerita.toList()
        }
    }
}