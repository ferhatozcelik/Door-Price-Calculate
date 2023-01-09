package com.ferhatozcelik.doorpricecalculate.ui.fragments.cost

import android.content.Context
import androidx.lifecycle.ViewModel
import com.ferhatozcelik.doorpricecalculate.repository.CostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class CostCalculateViewModel @Inject constructor(
    private val searchRepository: CostRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {


}