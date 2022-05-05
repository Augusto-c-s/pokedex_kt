package com.ascafi.pokedex_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ascafi.pokedex_kt.R
import com.ascafi.pokedex_kt.domain.Pokemon
import com.ascafi.pokedex_kt.view.PokemonAdapter
import com.ascafi.pokedex_kt.viewmodel.PokemonViewModel
import com.ascafi.pokedex_kt.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerViewPokemon)
    }

    private val viewModel by lazy {
        ViewModelProvider(this,
            PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.pokemons.observe(this, {
            recyclerViewLoad(it)
        })
    }

    private fun recyclerViewLoad(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}