package sdu.halal.halalchecker.presentation.scanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sdu.halal.halalchecker.R
import sdu.halal.halalchecker.databinding.FragmentCategoryBinding
import sdu.halal.halalchecker.databinding.FragmentInfoProductBinding

class InfoProductFragment : Fragment() {

    private var _binding : FragmentInfoProductBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoProductBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardView.setOnClickListener {
            findNavController().navigate(R.id.action_infoProductFragment_to_addProductFragment1)
        }
    }
}