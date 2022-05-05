package com.ascafi.pokedex_kt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ascafi.pokedex_kt.domain.Pokemon
import com.ascafi.pokedex_kt.repository.RepositoryPokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    var pokemons = MutableLiveData<List<Pokemon?>>()

    fun runThreadPokemon() {
        GlobalScope.launch(Dispatchers.IO) {
            loadPokemons()
        }
    }

    private fun loadPokemons() {
        val pokemonsApiResult = RepositoryPokemon.listPokemon()

        pokemonsApiResult?.results?.let {
            pokemons.postValue(it.map { pokemonResult ->
                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonApiResult = RepositoryPokemon.getPokemon(number)

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map { type ->
                            type.type
                        }
                    )
                }
            })
        }
    }
}