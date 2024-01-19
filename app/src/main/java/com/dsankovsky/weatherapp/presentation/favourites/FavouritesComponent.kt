package com.dsankovsky.weatherapp.presentation.favourites

import com.dsankovsky.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface FavouritesComponent {

    val model: StateFlow<FavouritesStore.State>
    fun onClickSearch()
    fun onClickAddFavourite()
    fun onCityItemClick(city: City)

}