package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.di

import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.FragmentPokemonList
import dagger.BindsInstance
import dagger.Subcomponent


@Subcomponent(modules = [PokemonListModule::class])
interface PokemonListComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: FragmentPokemonList): PokemonListComponent
    }

    fun inject(fragment: FragmentPokemonList)
}