package sdu.halal.halalchecker.presentation.home

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import sdu.halal.halalchecker.R
import sdu.halal.halalchecker.databinding.FragmentHomeBinding

private const val MAX_CATEGORY_ITEMS_COUNT = 5
private const val MAX_ADDITIVE_ITEMS_COUNT = 7
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val repository : CategoryRepository by lazy {
        CategoryRepository()
    }
    private lateinit var viewModel: HomeViewModel
    private lateinit var categoryAdapter : CategoryItemsAdapter
    private lateinit var additiveAdapter: AdditiveAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val viewModelFactory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[HomeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        halalSpanText()


        categoryAdapter = CategoryItemsAdapter()
        binding.recyclerCategory.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false)
        binding.recyclerCategory.adapter = categoryAdapter


        categoryAdapter.setItemClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
        }

        binding.textCategoryAll.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
        }



        categoryItemsRecycler()
        additiveItemsRecycler()
        observeCategoryData()
        observeAdditiveData()

    }

    private fun categoryItemsRecycler(){

    }
    private fun additiveItemsRecycler(){
        additiveAdapter = AdditiveAdapter()
        binding.recyclerAdditivies.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false)
        binding.recyclerAdditivies.adapter = additiveAdapter
    }

    private fun observeCategoryData(){
        viewModel.categoryData.observe(viewLifecycleOwner) { categoryData ->
            val subList = categoryData.take(MAX_CATEGORY_ITEMS_COUNT)
            categoryAdapter.submitList(subList)
        }
    }
    private fun observeAdditiveData(){
        viewModel.additiveData.observe(viewLifecycleOwner) { additiveData ->
            val subList = additiveData.take(MAX_ADDITIVE_ITEMS_COUNT)
            additiveAdapter.submitList(subList)
        }
    }
    private fun halalSpanText(){
        val halalText = getString(R.string.halal_checker)
        val spannableText = SpannableString(halalText)
        val colorSpan = ForegroundColorSpan(Color.parseColor("#65CF21"))
        spannableText.setSpan(colorSpan,0,5,0)
        binding.homeMainText.text = spannableText
    }

}