package sdu.halal.halalchecker.presentation.scanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sdu.halal.halalchecker.R
import sdu.halal.halalchecker.databinding.FragmentAddProduct1Binding
import sdu.halal.halalchecker.databinding.FragmentCategoryBinding

class AddProductFragment1 : Fragment() {

    private var _binding : FragmentAddProduct1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddProduct1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_addProductFragment1_to_addProductFragment2)
        }
    }
}