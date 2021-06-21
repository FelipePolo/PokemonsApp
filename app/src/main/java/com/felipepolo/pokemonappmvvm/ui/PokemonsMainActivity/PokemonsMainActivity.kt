package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.ApiPokemonServices
import com.felipepolo.pokemonappmvvm.databinding.ActivityMainBinding
import com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.FragmentPokemonList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonsMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setupTabLayout()

        ejemplo("1")
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