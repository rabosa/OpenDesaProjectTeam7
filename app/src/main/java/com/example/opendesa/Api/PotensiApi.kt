package com.example.opendesa.Api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PotensiApi {
    fun getInstance() : Retrofit{
        return Retrofit.Builder().baseUrl("http://192.168.1.4:8000/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    /* var BASE_URL:String="http://192.168.1.5:8000/api/"
     val endpoint: PotensiApiEndPoint
         get() {
             val retrofit = Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .client(client)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()

             return retrofit.create(PotensiApiEndPoint::class.java)

         }

     private val client: OkHttpClient
         get() {
             val interceptor = HttpLoggingInterceptor()
             interceptor.level = HttpLoggingInterceptor.Level.BODY

             return OkHttpClient.Builder()
                 .addInterceptor(interceptor)
                 .build()
         }*/
}