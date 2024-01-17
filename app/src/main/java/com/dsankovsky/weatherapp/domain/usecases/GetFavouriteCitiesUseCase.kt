package com.dsankovsky.weatherapp.domain.usecases

import com.dsankovsky.weatherapp.domain.entity.City
import com.dsankovsky.weatherapp.domain.repository.FavouritesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: FavouritesRepository
) {
    operator fun invoke(): Flow<List<City>> = repository.favouriteCities
}