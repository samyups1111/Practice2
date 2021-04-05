package samyups.example.practice2.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import samyups.example.practice2.R
import samyups.example.practice2.data.Pokemon

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    private var pokemonList: List<Pokemon> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun update(list: List<Pokemon>) {
        pokemonList = list
        notifyDataSetChanged()
    }
}