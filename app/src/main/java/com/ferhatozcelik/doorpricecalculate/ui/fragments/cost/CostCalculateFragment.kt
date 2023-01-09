package com.ferhatozcelik.doorpricecalculate.ui.fragments.cost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.ferhatozcelik.doorpricecalculate.R
import com.ferhatozcelik.doorpricecalculate.databinding.FragmentCostBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CostCalculateFragment : Fragment(R.layout.fragment_cost) {

    private val viewModel: CostCalculateViewModel by viewModels()
    private lateinit var binding: FragmentCostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCostBinding.inflate(inflater, container, false)

        binding.apply {
            searchButton.setOnClickListener {
                activity?.findNavController(R.id.nav_host_fragment)
                    ?.navigate(R.id.action_searchFragment_to_searchDetailFragment)
            }
        }


        return binding.root
    }

}