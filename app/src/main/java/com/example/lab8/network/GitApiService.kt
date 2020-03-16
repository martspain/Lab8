package com.example.lab8.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://github.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//Aqui se establece el usuario de github al cual se desea acceder (Si quieren probar cambiar el usuario hacerlo aqui)
//La app muestra el string html de la pagina obtenida
interface GitApiService{
    @GET("martspain")
    fun getProperties():
            Call<String>
}

object GitApi {
    val retrofitService : GitApiService by lazy {
        retrofit.create(GitApiService::class.java) }
}