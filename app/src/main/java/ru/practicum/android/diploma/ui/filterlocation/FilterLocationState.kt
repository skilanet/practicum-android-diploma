package ru.practicum.android.diploma.ui.filterlocation

import ru.practicum.android.diploma.domain.filter.entity.AreaEntity

data class FilterLocationState(
    val country: AreaEntity? = null,
    val region: AreaEntity? = null
)
