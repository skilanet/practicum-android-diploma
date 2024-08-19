package ru.practicum.android.diploma.ui.filterlocation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.practicum.android.diploma.domain.filter.FilterInteractor

class FilterLocationViewModel(
    filterInteractor: FilterInteractor
) : ViewModel() {

    private val mutableState = MutableLiveData(FilterLocationState())
    fun observeState(): LiveData<FilterLocationState> = mutableState

    init {
        val actualFilter = filterInteractor.getFilter()
        val country = actualFilter?.area?.country
        val region = actualFilter?.area?.region
        mutableState.postValue(FilterLocationState(country, region))
    }
}
