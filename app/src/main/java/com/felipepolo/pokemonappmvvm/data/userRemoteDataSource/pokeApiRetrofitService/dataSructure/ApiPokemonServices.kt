package com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiPokemonServices {
    @GET("generation/{id}")
    suspend fun getPokemonSources(@Path("id") id:String): Response<GenerationResponse>

    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name:String): Response<Pokemon>

}