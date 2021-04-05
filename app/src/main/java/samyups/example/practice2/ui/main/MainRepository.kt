package samyups.example.practice2.ui.main

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import samyups.example.practice2.data.MainDao
import samyups.example.practice2.data.Pokemon

class MainRepository(
    private val mainDao: MainDao
) {

    val PokemonList: Flow<List<Pokemon>> = mainDao.getPokemonList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addPokemon(pokemon: Pokemon) {
        mainDao.addPokemon(pokemon)
    }
}