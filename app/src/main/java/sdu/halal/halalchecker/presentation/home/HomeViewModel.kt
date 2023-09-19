package sdu.halal.halalchecker.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import sdu.halal.halalchecker.presentation.data.Additivies
import sdu.halal.halalchecker.presentation.data.ProductCategory

class HomeViewModel(repository: CategoryRepository) : ViewModel() {

    private val _categoryData = MutableLiveData<List<ProductCategory>>()
    val categoryData: LiveData<List<ProductCategory>> = _categoryData

    private val _additiveData = MutableLiveData<List<Additivies>>()
    val additiveData : LiveData<List<Additivies>> = _additiveData

    init {
        _categoryData.value = repository.getData()
        _additiveData.value = repository.getAdditiviesData()
    }
}