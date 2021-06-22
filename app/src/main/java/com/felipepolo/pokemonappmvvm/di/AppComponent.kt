package com.felipepolo.pokemonappmvvm.di

import android.content.Context
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.di.PokemonListComponent
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.di.MainPokemonsActivityComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubcomponentsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun MainPokemonsActivityComponent(): MainPokemonsActivityComponent.Factory
    fun PokemonListComponent(): PokemonListComponent.Factory
}

@Module(subcomponents = [MainPokemonsActivityComponent::class,PokemonListComponent::class])
class AppSubcomponentsModule