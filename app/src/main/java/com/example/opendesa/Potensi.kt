package com.example.opendesa


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Potensi(
    var potensiImage: Int,
    var potensiTitle: String,
    var potensiDesc: String
)  :Parcelable


