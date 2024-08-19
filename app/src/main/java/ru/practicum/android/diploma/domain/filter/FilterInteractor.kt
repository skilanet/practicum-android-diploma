package ru.practicum.android.diploma.domain.filter

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import ru.practicum.android.diploma.domain.filter.entity.Filter
import ru.practicum.android.diploma.domain.filter.entity.FilterSetting
import ru.practicum.android.diploma.domain.referenceinfo.entity.RegionListResource

interface FilterInteractor {
    fun saveSetting(setting: FilterSetting)
    fun getFilter(): Filter?
    fun getFilterFlow(): StateFlow<Filter?>
    fun isFilterPresent(): Boolean
    suspend fun getRegionsList(id: String?): Flow<RegionListResource>
}
