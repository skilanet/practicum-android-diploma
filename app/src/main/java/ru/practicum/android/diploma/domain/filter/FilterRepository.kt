package ru.practicum.android.diploma.domain.filter

import ru.practicum.android.diploma.domain.filter.entity.Filter
import ru.practicum.android.diploma.domain.filter.entity.FilterSetting

interface FilterRepository {
    fun saveSetting(setting: FilterSetting)
    fun getFilter(): Filter?

}
