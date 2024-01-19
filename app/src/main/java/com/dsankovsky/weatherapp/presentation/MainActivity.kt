package com.dsankovsky.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.dsankovsky.weatherapp.WeatherApp
import com.dsankovsky.weatherapp.presentation.root.DefaultRootComponent
import com.dsankovsky.weatherapp.presentation.root.RootContent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApp).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            RootContent(component = rootComponentFactory.create(defaultComponentContext()))
        }
    }
}