package samyups.example.practice2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import samyups.example.practice2.data.Pokemon
import samyups.example.practice2.ui.main.MainRepository

class MainViewModel(
    private val mainRepository: MainRepository
): ViewModel() {

    val getPokemonList: LiveData<List<Pokemon>> = mainRepository.PokemonList.asLiveData()

    fun addPokemon(pokemon: Pokemon) = viewModelScope.launch {
        mainRepository.addPokemon(pokemon)
    }
}