package com.felipepolo.pokemonappmvvm.data.userRemoteDataSource

import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.PokeApiRetrofitServices
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.ApiPokemonServices
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.Pokemon
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.PokemonInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor() {
    private val PokeApiRetrofit = PokeApiRetrofitServices.getPokeApiRetrofit()

    suspend fun getPokemons(names: ArrayList<String>): ArrayList<Pokemon> {
        return withContext(Dispatchers.IO) {
            val pokemons = ArrayList<Pokemon>()
            names.forEach {
                val pokemonResponse = PokeApiRetrofit.create(ApiPokemonServices::class.java).getPokemon(it)
                val pokemon = pokemonResponse.body()
                pokemon?.let {
                    pokemons.add(it)
                }
            }
            return@withContext pokemons
        }
    }

    suspend fun getAllPokemonsNames(id: String): ArrayList<PokemonInfo> {
        return withContext(Dispatchers.IO) {
            val response = PokeApiRetrofit.create(ApiPokemonServices::class.java).getPokemonSources(id)
            val generationResponse = response.body()
            return@withContext generationResponse?.pokemons_sources ?: ArrayList()
        }
    }

}