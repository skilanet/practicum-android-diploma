package ru.practicum.android.diploma.ui.filterlocation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.practicum.android.diploma.domain.filter.FilterInteractor
import ru.practicum.android.diploma.domain.filter.entity.FilterSetting

class FilterLocationViewModel(
    private val filterInteractor: FilterInteractor
) : ViewModel() {

    private val mutableState = MutableLiveData(FilterLocationState())
    fun observeState(): LiveData<FilterLocationState> = mutableState

    init {
        viewModelScope.launch {
            filterInteractor.getFilterFlow().collect { actualFilter ->
                val country = actualFilter?.area?.country
                val region = actualFilter?.area?.region
                mutableState.postValue(FilterLocationState(country, region))
            }
        }
    }

    fun clearCountry() {
        filterInteractor.saveSetting(FilterSetting.Area(null, mutableState.value?.region))
    }

    fun clearRegion() {
        filterInteractor.saveSetting(FilterSetting.Area(mutableState.value?.country, null))
    }
}
