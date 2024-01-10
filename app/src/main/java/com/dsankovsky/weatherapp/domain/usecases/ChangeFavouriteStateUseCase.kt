package com.dsankovsky.weatherapp.domain.usecases

import com.dsankovsky.weatherapp.domain.entity.City
import com.dsankovsky.weatherapp.domain.repository.FavouritesRepository
import javax.inject.Inject

class ChangeFavouriteStateUseCase @Inject constructor(
    private val repository: FavouritesRepository
) {
    suspend fun addToFavourite(city: City) = repository.addToFavourite(city)
    suspend fun removeFromFavourite(cityId: Int) = repository.removeFromFavourite(cityId)
}