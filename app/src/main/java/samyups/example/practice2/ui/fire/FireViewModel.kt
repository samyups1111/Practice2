package samyups.example.practice2.ui.fire

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.launch
import samyups.example.practice2.data.Pokemon

class FireViewModel (
    private val repository: FireRepository
): ViewModel() {
    fun getData() : DatabaseReference {
        return repository.currentUserReference()
    }
}