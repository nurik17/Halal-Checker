package sdu.halal.halalchecker.presentation.home.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sdu.halal.halalchecker.presentation.home.CategoryRepository
import sdu.halal.halalchecker.presentation.home.MainViewModel

class CategoryPageViewModelFactory(private val repository: CategoryRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
