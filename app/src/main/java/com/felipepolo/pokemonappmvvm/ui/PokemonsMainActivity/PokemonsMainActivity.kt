package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import com.felipepolo.pokemonappmvvm.TodoApplication
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.ApiPokemonServices
import com.felipepolo.pokemonappmvvm.databinding.ActivityMainBinding
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.FragmentPokemonList
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.adapters.AdapterViewPager
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.di.MainPokemonsActivityComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PokemonsMainActivity : AppCompatActivity() {


    lateinit var PokemonsMainComponent: MainPokemonsActivityComponent

    @Inject
    lateinit var viewModel: PokemonsViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as TodoApplication).appComponent.MainPokemonsActivityComponent().create(this).inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        setupTabLayout()
        viewModel._nombre.observe(this, Observer {
            binding.debug.text = it
        })

        binding.debug.setOnClickListener {
            val arrayname = arrayListOf("carlos","juan","pepito")

            viewModel.setNombre(arrayname.get((0..2).random()))
        }
    }

    override fun onResume() {
        super.onResume()
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun setupTabLayout(){
        val adaptador = AdapterViewPager(supportFragmentManager)
        var principalFragment = FragmentPokemonList();
        for(item in 1..6){

            val bundle = Bundle()
            bundle.putInt("generation",item)

            principalFragment.arguments = bundle

            if(item == 6){
                adaptador.addFragment(principalFragment,"My Fav")
            }else{
                adaptador.addFragment(principalFragment,"Gen $item")
            }
            principalFragment = FragmentPokemonList()
        }
        binding.viewpager.adapter = adaptador
        binding.tablayout.setupWithViewPager(binding.viewpager)
    }

    fun ejemplo(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = getRetrofit().create(ApiPokemonServices::class.java).getPokemonSources(query)
            val generationresponse = response.body()
            if(response.isSuccessful){
                println(generationresponse?.toString())
            }
        }
    }
}