package ru.practicum.android.diploma.domain.favorites

import kotlinx.coroutines.flow.Flow
import ru.practicum.android.diploma.domain.models.VacancyFull
import ru.practicum.android.diploma.domain.models.VacancyLight

interface FavoritesRepository {
    suspend fun addToFavorites(vacancy: VacancyFull)
    suspend fun removeFromFavorites(vacancyId: String)
    fun getFavorites(): Flow<List<VacancyLight>>
    fun checkVacancyInFavorites(vacancyId: String): Flow<Boolean>
}
