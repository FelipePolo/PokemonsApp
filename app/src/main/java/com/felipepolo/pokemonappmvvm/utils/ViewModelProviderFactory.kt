package com.felipepolo.pokemonappmvvm.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.felipepolo.pokemonappmvvm.data.userRepository
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.PokemonsViewModel
import java.lang.IllegalArgumentException


class ViewModelProviderFactory(private val repository: userRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PokemonsViewModel::class.java)){
            return PokemonsViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}