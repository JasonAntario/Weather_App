package com.dsankovsky.weatherapp

import android.app.Application
import com.dsankovsky.weatherapp.di.ApplicationComponent
import com.dsankovsky.weatherapp.di.DaggerApplicationComponent

class WeatherApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}