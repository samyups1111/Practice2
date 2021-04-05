package samyups.example.practice2.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import samyups.example.practice2.ui.fire.FireRepository
import samyups.example.practice2.ui.fire.FireViewModel

class FireViewModelFactory(
        private val fireRepository: FireRepository
): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return FireViewModel(fireRepository) as T
    }
}