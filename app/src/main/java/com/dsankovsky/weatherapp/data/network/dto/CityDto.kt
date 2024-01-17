package com.dsankovsky.weatherapp.data.network.dto


import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("country") val country: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)