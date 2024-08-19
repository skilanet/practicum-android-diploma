package ru.practicum.android.diploma.ui.filterlocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.practicum.android.diploma.databinding.FragmentFilterLocationBinding
import ru.practicum.android.diploma.util.BindingFragment

class FilterLocationFragment : BindingFragment<FragmentFilterLocationBinding>() {

    private val viewModel: FilterLocationViewModel by viewModel()

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentFilterLocationBinding {
        return FragmentFilterLocationBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        viewModel.observeState().observe(viewLifecycleOwner) {
            renderState(it)
        }
    }

    private fun renderState(state: FilterLocationState) {
        binding.edittextVacancyCountry.setText(state.country?.name)
        binding.edittextVacancyRegion.setText(state.region?.name)
    }
}
