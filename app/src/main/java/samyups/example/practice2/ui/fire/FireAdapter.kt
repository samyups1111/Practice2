package samyups.example.practice2.ui.fire

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import samyups.example.practice2.R
import samyups.example.practice2.data.Pokemon2

class FireAdapter: RecyclerView.Adapter<FireViewHolder>() {

    private var pokemonList: List<Pokemon2> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FireViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fire_recyclerview_item, parent, false)
        return FireViewHolder(view)
    }

    override fun onBindViewHolder(holder: FireViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun update(list: List<Pokemon2>) {
        pokemonList = list
        notifyDataSetChanged()
    }
}