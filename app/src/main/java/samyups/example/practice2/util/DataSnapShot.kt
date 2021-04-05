package samyups.example.practice2.util

import com.google.firebase.database.DataSnapshot
import samyups.example.practice2.data.Pokemon
import samyups.example.practice2.data.Pokemon2

fun DataSnapshot.asPokemon2(): Pokemon2? =
        getValue(Pokemon2::class.java)?.copy(id = key!!.toInt())