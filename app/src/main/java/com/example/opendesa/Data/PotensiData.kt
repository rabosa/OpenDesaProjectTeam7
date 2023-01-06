package com.example.opendesa.Data

import com.example.opendesa.Potensi
import com.example.opendesa.R
import java.util.*

class PotensiData {
    var potensiArrayList = Arrays.asList(*potensi)
    fun LoadPotensi(): List<Potensi> {
        return potensiArrayList
    }

    companion object {
        var potensi = arrayOf(
            Potensi(
                R.drawable.duriankumpeh,
                "Kampang",
                "Kuda Cuki",

                ),
            Potensi(
                R.drawable.dukukumpeh,
                "YYYYY",
                "OIIIII",

                ),
            Potensi(
                R.drawable.kelapasawit,
                "MANG EYAKK",
                "IYOOOO",

                ),
            Potensi(
                R.drawable.loji_belanda_muara_kumpeh_2,
                "KAMPANGGG",
                "YOOOOOO",

                ),
            Potensi(
                R.drawable.candi_sogo,
                "IAAA",
                "AKKAKAKKA"
            ),

            )
    }

}