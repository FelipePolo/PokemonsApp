package com.felipepolo.pokemonappmvvm.di

import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.pokeApiRetrofitService.PokeApiRetrofitServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    /*
    @Singleton
    @Provides
    fun provideApiPokemonsRetrofitServices(): PokeApiRetrofitServices{
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

     */
}