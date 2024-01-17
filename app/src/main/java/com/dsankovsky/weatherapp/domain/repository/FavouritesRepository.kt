package com.dsankovsky.weatherapp.domain.repository

import com.dsankovsky.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {
    val favouriteCities: Flow<List<City>>
    fun observeIsFavourite(cityId: Int): Flow<Boolean>
    suspend fun addToFavourite(city: City)
    suspend fun removeFromFavourite(cityId: Int)
}