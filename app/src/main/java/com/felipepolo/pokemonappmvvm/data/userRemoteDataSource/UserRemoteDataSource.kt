package com.felipepolo.pokemonappmvvm.data.userRemoteDataSource

import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.PokeApiRetrofitServices
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.ApiPokemonServices
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRemoteDataSource () {
    private val PokeApiRetrofit = PokeApiRetrofitServices.getPokeApiRetrofit()

    suspend fun getPokemons(id:String): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val pokemons = ArrayList<Pokemon>()
            val response = PokeApiRetrofit.create(ApiPokemonServices::class.java).getPokemonSources(id)
            val generationResponse = response.body()
            generationResponse?.let {
                it.pokemons_sources.forEach {
                    val pokemonResponse = PokeApiRetrofit.create(ApiPokemonServices::class.java).getPokemon(it.name)
                    val pokemon = pokemonResponse.body()
                    pokemon?.let {
                        pokemons.add(it)
                    }
                }
            }
            return@withContext pokemons
        }
    }

}