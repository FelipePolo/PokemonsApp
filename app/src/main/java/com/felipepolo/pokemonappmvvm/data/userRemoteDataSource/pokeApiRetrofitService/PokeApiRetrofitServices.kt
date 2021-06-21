package com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object PokeApiRetrofitServices{
    private val BASE_POKEAPI_URL = "https://pokeapi.co/api/v2/"

    @Singleton
    fun getPokeApiRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_POKEAPI_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}