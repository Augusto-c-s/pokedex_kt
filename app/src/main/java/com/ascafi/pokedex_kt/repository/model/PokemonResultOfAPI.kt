package com.ascafi.pokedex_kt.repository.model

import com.ascafi.pokedex_kt.domain.TypesOfPokemon

data class PokemonResultOfAPI(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PkTypeSlot>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PkTypeSlot(
    val slot: Int,
    val type: TypesOfPokemon
)