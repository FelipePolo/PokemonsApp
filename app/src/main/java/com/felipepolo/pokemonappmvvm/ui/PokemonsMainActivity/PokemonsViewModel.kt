package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity

import android.util.MutableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.felipepolo.pokemonappmvvm.data.userRepository
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(private val userRepository: userRepository): ViewModel() {
    // hacer mañana.
    var _nombre = MutableLiveData("")

    fun setNombre (nombre:String) {
        _nombre.value = nombre
    }


}