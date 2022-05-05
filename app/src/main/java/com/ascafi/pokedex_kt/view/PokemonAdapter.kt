package com.ascafi.pokedex_kt.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ascafi.pokedex_kt.R
import com.ascafi.pokedex_kt.domain.Pokemon
import com.bumptech.glide.Glide

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
        //TODO fazer em binding
//        val binding = (holder as PokemonViewHolder).binding
//        binding?.executePendingBindings()
//        binding?.

    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon?) = with(itemView) {
            val imagePokemon = findViewById<ImageView>(R.id.imagePokemon)
            val txtNumberPokemon = findViewById<TextView>(R.id.txtNumberPokemon)
            val txtNamePokemon = findViewById<TextView>(R.id.txtNamePokemon)
            val txtTypePokemon1 = findViewById<TextView>(R.id.txtTypePokemon1)
            val txtTypePokemon2 = findViewById<TextView>(R.id.txtTypePokemon2)

            item?.let {
                Glide.with(itemView.context).load(it.imageURL).into(imagePokemon)

                txtNumberPokemon.text = "Nº ${item.formattedNumber}"
                txtNamePokemon.text = item.name.uppercase()
                txtTypePokemon1.text = item.types[0].name.uppercase()

                if (item.types.size > 1) {
                    txtTypePokemon2.visibility = View.VISIBLE
                    txtTypePokemon2.text = item.types[1].name.uppercase()
                } else {
                    txtTypePokemon2.visibility = View.GONE
                }


            }
//        val binding: ViewDataBinding? = DataBindingUtil.bind(itemView)
        }

    }
}