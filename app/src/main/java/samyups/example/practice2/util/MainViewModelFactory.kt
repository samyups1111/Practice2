package samyups.example.practice2.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import samyups.example.practice2.ui.main.MainRepository
import samyups.example.practice2.ui.main.MainViewModel

class MainViewModelFactory(
    private val mainRepository: MainRepository
): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepository) as T
    }
}