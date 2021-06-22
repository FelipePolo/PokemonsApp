package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.di

import androidx.lifecycle.ViewModelProvider
import com.felipepolo.pokemonappmvvm.data.userRepository
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.FragmentPokemonList
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.PokemonListViewModel
import com.felipepolo.pokemonappmvvm.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides


@Module
class PokemonListModule {

    @Provides
    fun provideFragmentPokemonListViewModel(
            fragment: FragmentPokemonList,
            repository: userRepository
    ): PokemonListViewModel {
        val factory = ViewModelProviderFactory(repository)
        val viewmodel = ViewModelProvider(fragment,factory).get(PokemonListViewModel::class.java)
        return viewmodel
    }
}