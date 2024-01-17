package com.dsankovsky.weatherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dsankovsky.weatherapp.data.network.api.ApiFactory
import com.dsankovsky.weatherapp.presentation.ui.theme.WeatherAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiService = ApiFactory.apiService
        CoroutineScope(Dispatchers.IO).launch {
            val currentWeather = apiService.loadCurrentWeather("minsk")
            val forecast = apiService.loadForecast("minsk")
            val search = apiService.searchCity("minsk")
            Log.e("MainActivity", "CurW: $currentWeather \n" +
                    "ForcW: $forecast \n" +
                    "Cities: $search")
        }
        setContent {
            WeatherAppTheme {

            }
        }
    }
}