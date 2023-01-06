package com.example.opendesa.api

import com.example.opendesa.model.Berita
import retrofit2.http.GET

interface OpenDesaApi {
    @GET("api/berita-desa")
    suspend fun getBerita(): List<List<Berita>>
}