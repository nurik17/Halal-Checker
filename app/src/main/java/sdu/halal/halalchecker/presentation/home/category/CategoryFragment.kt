package sdu.halal.halalchecker.presentation.home.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import sdu.halal.halalchecker.R
import sdu.halal.halalchecker.presentation.home.category.CategoryViewModel
import sdu.halal.halalchecker.databinding.FragmentCategoryBinding
import sdu.halal.halalchecker.presentation.home.CategoryRepository
import sdu.halal.halalchecker.presentation.home.HomeViewModelFactory
import sdu.halal.halalchecker.presentation.home.MainViewModel


class CategoryFragment : Fragment() {

    private var _binding : FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private lateinit var categoryPageAdapter : CategoryPageAdapter
    private val repository by lazy {
        CategoryRepository()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentCategoryBinding.inflate(inflater,container,false)

        val viewModelFactory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        categoryPageAdapter = CategoryPageAdapter()
        binding.recycletFragmentCategory.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recycletFragmentCategory.adapter = categoryPageAdapter

        viewModel.categoryData.observe(viewLifecycleOwner){dataCategory->
            categoryPageAdapter.submitList(dataCategory)
        }
        categoryPageAdapter.setItemClickListener {
            findNavController().navigate(R.id.action_categoryFragment_to_infoProductFragment)
        }
    }
}