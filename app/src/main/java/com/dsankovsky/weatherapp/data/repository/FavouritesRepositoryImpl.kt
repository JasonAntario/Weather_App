package com.dsankovsky.weatherapp.data.repository

import com.dsankovsky.weatherapp.data.local.db.FavouriteCitiesDao
import com.dsankovsky.weatherapp.data.mapper.toDbModel
import com.dsankovsky.weatherapp.data.mapper.toEntities
import com.dsankovsky.weatherapp.domain.entity.City
import com.dsankovsky.weatherapp.domain.repository.FavouritesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao
) : FavouritesRepository {
    override val favouriteCities: Flow<List<City>> = favouriteCitiesDao.getFavouriteCities()
        .map { it.toEntities() }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> =
        favouriteCitiesDao.observeIsFavourite(cityId)

    override suspend fun addToFavourite(city: City) {
        favouriteCitiesDao.addToFavourite(city.toDbModel())
    }

    override suspend fun removeFromFavourite(cityId: Int) {
        favouriteCitiesDao.removeFromFavourite(cityId)
    }
}