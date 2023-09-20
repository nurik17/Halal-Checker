package sdu.halal.halalchecker.presentation.home.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sdu.halal.halalchecker.presentation.data.ProductCategory
import sdu.halal.halalchecker.presentation.home.CategoryRepository

class CategoryViewModel(repository: CategoryRepository) : ViewModel() {

    private val _categoryData = MutableLiveData<List<ProductCategory>>()
    val categoryData: LiveData<List<ProductCategory>> = _categoryData

    init {
        _categoryData.value = repository.getData()
    }
}