package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.felipepolo.pokemonappmvvm.R
import com.felipepolo.pokemonappmvvm.TodoApplication
import com.felipepolo.pokemonappmvvm.databinding.FragmentPokemonListBinding
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.PokemonsViewModel
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentPokemonList : Fragment() {

    lateinit var binding: FragmentPokemonListBinding

    @Inject
    lateinit var viewModel: PokemonListViewModel

    override fun onAttach(context: Context) {
        (requireActivity().application as TodoApplication).appComponent
                .PokemonListComponent()
                .create(this)
                .inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.init(requireArguments().get("generation").toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        suscribe()
    }

    private fun suscribe() {
        viewModel.pokemonList.observe(viewLifecycleOwner, Observer {
            Log.d("completed",it.toString())
        })
    }

}