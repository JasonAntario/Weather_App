package com.dsankovsky.weatherapp.data.mapper

import com.dsankovsky.weatherapp.data.network.dto.CityDto
import com.dsankovsky.weatherapp.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }