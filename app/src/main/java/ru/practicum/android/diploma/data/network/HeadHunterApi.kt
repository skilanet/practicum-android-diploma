package ru.practicum.android.diploma.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.QueryMap
import ru.practicum.android.diploma.data.dto.Area
import ru.practicum.android.diploma.data.dto.AreaParent
import ru.practicum.android.diploma.data.dto.IndustryParent
import ru.practicum.android.diploma.data.dto.VacanciesSearchResponse
import ru.practicum.android.diploma.data.dto.VacancyDto

interface HeadHunterApi {
    @GET("/vacancies")
    suspend fun searchVacancies(
        @QueryMap params: Map<String, String>,
        @HeaderMap headers: Map<String, String>
    ): Response<VacanciesSearchResponse>

    @GET("/vacancies/{vacancy_id}")
    suspend fun getVacancy(
        @Path("vacancy_id") id: String,
        @HeaderMap headers: Map<String, String>
    ): Response<VacancyDto>

    @GET("/industries")
    suspend fun getIndustries(
        @HeaderMap headers: Map<String, String>
    ): Response<List<IndustryParent>>

    @GET("/areas/{area_id}")
    suspend fun getAreasForCountryId(
        @Path("area_id") id: String,
        @HeaderMap headers: Map<String, String>
    ): Response<AreaParent>

    @GET("/areas")
    suspend fun getAreas(
        @HeaderMap headers: Map<String, String>
    ): Response<List<AreaParent>>

    @GET("/areas")
    suspend fun getCountries(
        @HeaderMap headers: Map<String, String>
    ): Response<List<Area>>

}
