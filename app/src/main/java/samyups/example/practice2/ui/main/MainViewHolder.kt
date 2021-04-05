package samyups.example.practice2.ui.main

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import samyups.example.practice2.R
import samyups.example.practice2.data.Pokemon

class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val pokeIdView: TextView = itemView.findViewById(R.id.recycler_item_id_edittext)
    private val pokeNameView: TextView = itemView.findViewById(R.id.recycler_item_name_edittext)
    private val pokeTypeView: TextView = itemView.findViewById(R.id.recycler_item_type_edittext)

    fun bind(pokemon: Pokemon) {
        pokeIdView.text = pokemon.id.toString()
        pokeNameView.text = pokemon.name
        pokeTypeView.text = pokemon.type
    }
}