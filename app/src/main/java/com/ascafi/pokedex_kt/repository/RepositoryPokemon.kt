package com.ascafi.pokedex_kt.repository


import com.ascafi.pokedex_kt.repository.model.PokemonApiResult
import com.ascafi.pokedex_kt.repository.model.PokemonResultOfAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RepositoryPokemon {
    //https://pokeapi.co/api/v2/pokemon?limit=1126
    private val service: ServicePokemon

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ServicePokemon::class.java)
    }

    fun listPokemon(limit: Int = 1126) : PokemonResultOfAPI? {
        val call = service.listPokemon(limit)
        return call.execute().body()
    }

    fun getPokemon(number: Int) : PokemonApiResult? {
        val call = service.getPokemon(number)
        return call.execute().body()
    }
}