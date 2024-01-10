package com.dsankovsky.weatherapp.domain.usecases

import com.dsankovsky.weatherapp.domain.repository.FavouritesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveFavouriteStateUseCase @Inject constructor(
    private val repository: FavouritesRepository
) {
    operator fun invoke(citiId: Int): Flow<Boolean> = repository.observeIsFavourite(citiId)
}