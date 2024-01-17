package com.dsankovsky.weatherapp.data.repository

import com.dsankovsky.weatherapp.data.mapper.toEntities
import com.dsankovsky.weatherapp.data.network.api.ApiService
import com.dsankovsky.weatherapp.domain.entity.City
import com.dsankovsky.weatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {
    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}