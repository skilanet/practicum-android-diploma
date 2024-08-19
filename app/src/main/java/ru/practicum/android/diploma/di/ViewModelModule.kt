package ru.practicum.android.diploma.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.practicum.android.diploma.presentation.favorites.FavoritesViewModel
import ru.practicum.android.diploma.presentation.vacancyinfo.VacancyInfoViewModel
import ru.practicum.android.diploma.ui.filterlocation.FilterLocationViewModel
import ru.practicum.android.diploma.ui.search.SearchViewModel

val viewModelModule = module {
    viewModelOf(::FavoritesViewModel)
    viewModelOf(::VacancyInfoViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::FilterLocationViewModel)
}
