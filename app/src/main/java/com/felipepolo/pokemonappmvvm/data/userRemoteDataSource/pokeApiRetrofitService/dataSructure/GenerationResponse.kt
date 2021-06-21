package com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.dataSructure

import com.google.gson.annotations.SerializedName

data class GenerationResponse(
    @SerializedName("pokemon_species")
    var pokemons_sources: ArrayList<PokemonInfo>
)

data class PokemonInfo(
    var name: String
)

data class Pokemon(
    var id:Int,
    var name: String,
    @SerializedName("base_experience")
    var xp: Int,
    var height:Int,
    var weight:Int,
    var types: ArrayList<TypeInfo>,
    var stats: ArrayList<Stats>,
    var sprites: Sprites,
    var moves: ArrayList<Moves>
)

data class TypeInfo(
    var Type: Type
)

data class Type(
    var name: String
)
data class Stats(
    var base_stat:Int,
    var stat: Stat
)
data class Stat(
    var name: String
)
data class Sprites(
    @SerializedName("front_default")
    var lowImgUrl: String,
    var other: Other
)
data class Other(
    @SerializedName("dream_world")
    var highImg: HighImg
)
data class  HighImg(
    @SerializedName("front_default")
    var highImgUrl:String
)
data class Moves(
    var move: Move
)
data class Move(
    var name: String
)