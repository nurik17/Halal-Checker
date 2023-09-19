package sdu.halal.halalchecker.presentation.home.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sdu.halal.halalchecker.presentation.home.CategoryRepository
import sdu.halal.halalchecker.presentation.home.HomeViewModel

class CategoryPageViewModelFactory(private val repository: CategoryRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
