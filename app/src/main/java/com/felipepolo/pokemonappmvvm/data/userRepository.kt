package com.felipepolo.pokemonappmvvm.data

import com.felipepolo.pokemonappmvvm.data.userLocalDataSource.userLocaDataSource
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.UserRemoteDataSource
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.Pokemon
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.PokemonInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class userRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: userLocaDataSource
    ) {

    suspend fun getPokemonNamesByGeneration(id:String): ArrayList<PokemonInfo> {
        return userRemoteDataSource.getAllPokemonsNames(id)
    }

    suspend fun getPokemons(names: ArrayList<String>): ArrayList<Pokemon>{
        return userRemoteDataSource.getPokemons(names)
    }

}