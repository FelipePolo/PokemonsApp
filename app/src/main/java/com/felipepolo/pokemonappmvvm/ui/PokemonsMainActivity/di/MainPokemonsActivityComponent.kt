package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.di

import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.FragmentPokemonList
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.PokemonsMainActivity
import dagger.BindsInstance
import dagger.Subcomponent


@Subcomponent(modules = [PokemonsMainModel::class])
interface MainPokemonsActivityComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(@BindsInstance activity: PokemonsMainActivity): MainPokemonsActivityComponent
    }

    fun inject(activity: PokemonsMainActivity)
}