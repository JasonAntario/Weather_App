package com.dsankovsky.weatherapp.data.mapper

import com.dsankovsky.weatherapp.data.network.dto.WeatherCurrentDto
import com.dsankovsky.weatherapp.data.network.dto.WeatherDto
import com.dsankovsky.weatherapp.data.network.dto.WeatherForecastDto
import com.dsankovsky.weatherapp.domain.entity.Forecast
import com.dsankovsky.weatherapp.domain.entity.Weather
import java.util.Calendar
import java.util.Date

fun WeatherCurrentDto.toEntity(): Weather = current.toEntity()
fun WeatherForecastDto.toEntity(): Forecast = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecast.forecastDay.drop(1).map { dayDto ->
        val dayWeatherDto = dayDto.dayWeatherDto
        Weather(
            tempC = dayWeatherDto.tempC,
            conditionText = dayWeatherDto.condition.text,
            conditionUrl = dayWeatherDto.condition.iconUrl.correctImageUrl(),
            date = dayDto.date.toCalendar()
        )
    }
)

fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionText = condition.text,
    conditionUrl = condition.iconUrl.correctImageUrl(),
    date = date.toCalendar()
)

private fun Long.toCalendar() = Calendar.getInstance().apply {
    time = Date(this@toCalendar * 1000)
}

private fun String.correctImageUrl() = "https:${
    this.replace(
        oldValue = "64x64",
        newValue = "128x128"
    )
}"