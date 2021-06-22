package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.di

import androidx.lifecycle.ViewModelProvider
import com.felipepolo.pokemonappmvvm.data.userRepository
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.PokemonsMainActivity
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.PokemonsViewModel
import com.felipepolo.pokemonappmvvm.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides


@Module
class PokemonsMainModel {

    @Provides
    fun providePokemonsMainViewModel(
            activity: PokemonsMainActivity,
            repository: userRepository
    ): PokemonsViewModel {

        val factory = ViewModelProviderFactory(repository)
        return ViewModelProvider(activity, factory).get(PokemonsViewModel::class.java)
    }

    @Provides
    fun providePokemonsViewModelFactory(
            repository: userRepository
    ): ViewModelProviderFactory {

        return ViewModelProviderFactory(repository)
    }
}