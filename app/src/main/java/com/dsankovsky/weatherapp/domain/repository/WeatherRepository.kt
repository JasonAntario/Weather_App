package com.dsankovsky.weatherapp.domain.repository

import com.dsankovsky.weatherapp.domain.entity.Forecast
import com.dsankovsky.weatherapp.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather
    suspend fun getForecast(cityId: Int): Forecast

}