package com.felipepolo.pokemonappmvvm.data

import com.felipepolo.pokemonappmvvm.data.userLocalDataSource.userLocaDataSource
import com.felipepolo.pokemonappmvvm.data.userRemoteDataSource.UserRemoteDataSource
import javax.inject.Inject

class userRepository @Inject constructor(
    private val UserRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: userLocaDataSource
    ) {

    //suspend fun getPokemons

}