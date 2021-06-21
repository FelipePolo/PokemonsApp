package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.di

import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.PokemonsMainActivity
import dagger.Subcomponent


@Subcomponent(modules = [PokemonsMainModel::class])
interface MainPokemonsActivityComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): MainPokemonsActivityComponent
    }

    fun inject(activity: PokemonsMainActivity)
}