package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments

import android.util.Log
import androidx.lifecycle.*
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.GenerationResponse
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.Pokemon
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.PokemonInfo
import com.felipepolo.pokemonappmvvm.data.userRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(private val userRepository: userRepository) : ViewModel() {

    private lateinit var generationId: String

    private var lastPokemonInListIndex: Int = 0
    private val context = viewModelScope.coroutineContext + Dispatchers.Main
    private var pokemonNames: ArrayList<PokemonInfo> = ArrayList()

    // Pokemon List Observable

    private var _pokemonList: MutableLiveData<ArrayList<Pokemon>> = MutableLiveData()
    val pokemonList: LiveData<ArrayList<Pokemon>> = _pokemonList

    fun init(id: String) {
        this.generationId = id
        CoroutineScope(context).launch {
            try {
                pokemonNames = userRepository.getPokemonNamesByGeneration(generationId)
                getPokemons()
            } catch (e: Exception) {
                //show some error
            }
        }
    }

    fun getPokemons() {
        CoroutineScope(context).launch {
            if (pokemonNames.isNotEmpty()) {
                val requestPokemons = getPokemonsToFeth()
                if (requestPokemons.isNotEmpty()) {
                    val pokemonsToAdd = userRepository.getPokemons(requestPokemons)
                    val currentStateList = pokemonList.value ?: ArrayList()
                    currentStateList.addAll(pokemonsToAdd)
                    _pokemonList.postValue(currentStateList)
                }
            }
        }
    }


    private fun getPokemonsToFeth(): ArrayList<String> {
        val requestPokemons = ArrayList<String>()
        (1..5).forEach {
            if (lastPokemonInListIndex < pokemonNames.size) {
                requestPokemons.add(pokemonNames[lastPokemonInListIndex].name)
                lastPokemonInListIndex++
            }
        }
        return requestPokemons
    }
}