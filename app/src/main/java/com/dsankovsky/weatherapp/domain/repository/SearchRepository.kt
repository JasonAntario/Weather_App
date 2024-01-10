package com.dsankovsky.weatherapp.domain.repository

import com.dsankovsky.weatherapp.domain.entity.City

interface SearchRepository {
    suspend fun search(query: String): List<City>
}