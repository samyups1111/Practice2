package samyups.example.practice2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)

abstract class MainDatabase: RoomDatabase() {

    abstract fun mainDao() : MainDao

    companion object {

        @Volatile private var INSTANCE : MainDatabase? = null

        fun getInstance(context: Context): MainDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "PokemonDatabase"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}