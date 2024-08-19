package ru.practicum.android.diploma.ui.filterlocation

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.practicum.android.diploma.R
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
        binding.edittextVacancyCountry.setOnClickListener { goToCountry() }
        binding.edittextVacancyRegion.setOnClickListener { goToRegion() }
        viewModel.observeState().observe(viewLifecycleOwner) {
            renderState(it)
        }
    }

    private fun goToCountry() {
        findNavController().navigate(R.id.action_filterLocationFragment_to_filterCountryFragment)
    }

    private fun goToRegion() {
        findNavController().navigate(R.id.action_filterLocationFragment_to_filterRegionFragment)
    }

    @Suppress("detekt.CognitiveComplexMethod")
    private fun renderState(state: FilterLocationState) {
        listOf(binding.textlayoutVacancyCountry, binding.textlayoutVacancyRegion)
            .zip(listOf(binding.edittextVacancyCountry, binding.edittextVacancyRegion))
            .zip(listOf(state.country, state.region))
            .forEachIndexed { index, triple ->
                val textInputLayout = triple.first.first
                val editText = triple.first.second
                val area = triple.second
                val textColorRes = if (area == null) R.color.gray_B4 else R.color.main_black_22
                val iconRes = if (area == null) R.drawable.arrow_forward_ic else R.drawable.close_ic
                editText.setText(area?.name)
                editText.setTextColor(requireContext().getColor(textColorRes))
                editText.setHintTextColor(requireContext().getColor(textColorRes))
                textInputLayout.defaultHintTextColor = ColorStateList.valueOf(requireContext().getColor(textColorRes))
                textInputLayout.setEndIconDrawable(iconRes)
                textInputLayout.setEndIconOnClickListener {
                    if (area == null) {
                        when (index) {
                            0 -> goToCountry()
                            1 -> goToRegion()
                        }
                    } else {
                        editText.text = null
                        when (index) {
                            0 -> viewModel.clearCountry()
                            1 -> viewModel.clearRegion()
                        }
                    }
                }
            }
    }
}
