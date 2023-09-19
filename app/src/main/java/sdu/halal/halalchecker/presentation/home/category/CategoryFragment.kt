package sdu.halal.halalchecker.presentation.home.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import sdu.halal.halalchecker.databinding.FragmentCategoryBinding
import sdu.halal.halalchecker.presentation.home.CategoryRepository
import sdu.halal.halalchecker.presentation.home.HomeViewModel


class CategoryFragment : Fragment() {

    private var _binding : FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter : CategoryPageAdapter
    private val repository by lazy {
        CategoryRepository()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentCategoryBinding.inflate(inflater,container,false)

        val viewModelFactory = CategoryPageViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[HomeViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        adapter = CategoryPageAdapter()
        binding.recycletFragmentCategory.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recycletFragmentCategory.adapter = adapter

        viewModel.categoryData.observe(viewLifecycleOwner){dataCategory->
            adapter.submitList(dataCategory)
        }

    }
}