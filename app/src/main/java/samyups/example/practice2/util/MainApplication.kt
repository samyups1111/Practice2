package samyups.example.practice2.util

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import samyups.example.practice2.data.MainDatabase
import samyups.example.practice2.ui.fire.FireRepository
import samyups.example.practice2.ui.main.MainRepository

class MainApplication: Application() {

    val mainDatabase by lazy { MainDatabase.getInstance(this) }

    val mainRepository by lazy { MainRepository(mainDatabase.mainDao()) }

    val fireDatabase by lazy { FirebaseDatabase.getInstance().reference }


    val fireRepository by lazy { FireRepository(fireDatabase)}
}