package com.example.opendesa.Api
import com.example.opendesa.Data.Data
import com.example.opendesa.Data.PotensiModelData
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response

interface PotensiApiEndPoint {
    @GET("potensi")
    suspend fun getPotensiData(): Response<PotensiModelData>
}