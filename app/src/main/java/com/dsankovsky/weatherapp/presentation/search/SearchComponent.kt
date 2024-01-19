package com.dsankovsky.weatherapp.presentation.search

import com.dsankovsky.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface SearchComponent {

    val model: StateFlow<SearchStore.State>

    fun onChangeSearchQuery(query: String)
    fun onClickBack()
    fun onClickSearch()
    fun onClickCity(city: City)

}