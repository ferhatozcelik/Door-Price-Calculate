package com.ferhatozcelik.doorpricecalculate.ui.fragments.costdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ferhatozcelik.doorpricecalculate.R
import com.ferhatozcelik.doorpricecalculate.databinding.FragmentCostDetailBinding
import com.ferhatozcelik.doorpricecalculate.util.ProgressDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CostDetailFragment : Fragment(R.layout.fragment_cost_detail) {

    private val viewModel: CostDetailViewModel by viewModels()
    private lateinit var binding: FragmentCostDetailBinding
    private lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCostDetailBinding.inflate(inflater, container, false)
        progressDialog = activity?.let { ProgressDialog(it) }!!

        return binding.root
    }



}