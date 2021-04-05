package samyups.example.practice2.ui.fire

import samyups.example.practice2.data.Pokemon
import java.lang.Exception

data class Response(
    var pokemons: List<Pokemon>? = null,
    var exception: Exception? = null
)