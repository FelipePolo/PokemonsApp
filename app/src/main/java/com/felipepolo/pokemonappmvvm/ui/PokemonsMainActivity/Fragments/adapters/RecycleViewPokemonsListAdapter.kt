package com.felipepolo.pokemonappmvvm.ui.PokemonsMainActivity.Fragments.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.felipepolo.pokemonappmvvm.R
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure.Pokemon
import com.felipepolo.pokemonappmvvm.databinding.TemplatePokemonListBinding
import com.skydoves.progressview.ProgressView
import com.squareup.picasso.Picasso

class RecycleViewPokemonsListAdapter(
    var pokemons: ArrayList<Pokemon>
) : RecyclerView.Adapter<RecycleViewPokemonsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.template_pokemon_list, parent, false)
        val ViewHolder = ViewHolder(itemView)
        return ViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemons.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val binding = TemplatePokemonListBinding.bind(itemView)

        fun bind(pokemon: Pokemon){
            // xp bar
            binding.expBar.labelText = "Base xp" + pokemon.xp
            binding.expBar.progress = pokemon.xp.toFloat()

            // block of stats(attack, defense, healt, speed)
            binding.tvhp.text =  pokemon.stats[0].base_stat.toString()
            binding.tvattack.text = pokemon.stats[2].base_stat.toString()
            binding.tvattack.text = pokemon.stats[1].base_stat.toString()
            binding.tvspeed.text = pokemon.stats[5].base_stat.toString()

            // name and image
            binding.pokemonName.text = pokemon.name
            Picasso.get()
                    .load(pokemon.sprites.lowImgUrl)
                    .into(binding.pokemonImagen)

        }
    }
}