package samyups.example.practice2.ui.fire

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import samyups.example.practice2.data.Pokemon

class FireRepository(private val fireDatabase: DatabaseReference) {

    fun currentUserReference() = fireDatabase.child("1")
}