package com.ascafi.pokedex_kt.repository

import com.ascafi.pokedex_kt.repository.model.PokemonApiResult
import com.ascafi.pokedex_kt.repository.model.PokemonResultOfAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServicePokemon {
    @GET("pokemon")
    fun listPokemon(@Query("limit") limit: Int) : Call<PokemonResultOfAPI>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int) : Call<PokemonApiResult>
}