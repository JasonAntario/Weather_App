package com.dsankovsky.weatherapp.di

import android.content.Context
import com.dsankovsky.weatherapp.data.local.db.FavouriteCitiesDao
import com.dsankovsky.weatherapp.data.local.db.FavouriteDatabase
import com.dsankovsky.weatherapp.data.network.api.ApiFactory
import com.dsankovsky.weatherapp.data.network.api.ApiService
import com.dsankovsky.weatherapp.data.repository.FavouritesRepositoryImpl
import com.dsankovsky.weatherapp.data.repository.SearchRepositoryImpl
import com.dsankovsky.weatherapp.data.repository.WeatherRepositoryImpl
import com.dsankovsky.weatherapp.domain.repository.FavouritesRepository
import com.dsankovsky.weatherapp.domain.repository.SearchRepository
import com.dsankovsky.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouritesRepositoryImpl): FavouritesRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {
        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavouriteDatabase(context: Context): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavouriteCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}