package com.felipepolo.pokemonappmvvm.di

import android.content.Context
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.di.MainPokemonsActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun MainPokemonsActivityComponent(): MainPokemonsActivityComponent.Factory
}