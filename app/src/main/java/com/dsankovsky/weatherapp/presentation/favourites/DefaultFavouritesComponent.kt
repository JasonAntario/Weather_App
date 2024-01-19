package com.dsankovsky.weatherapp.presentation.favourites

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.dsankovsky.weatherapp.domain.entity.City
import com.dsankovsky.weatherapp.presentation.extensions.componentScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DefaultFavouritesComponent @AssistedInject constructor(
    private val favouritesStoreFactory: FavouritesStoreFactory,
    @Assisted("onCityItemClicked") private val onCityItemClicked: (City) -> Unit,
    @Assisted("onAddToFavouriteClick") private val onAddToFavouriteClick: () -> Unit,
    @Assisted("onSearchClicked") private val onSearchClicked: () -> Unit,
    @Assisted("componentContext") componentContext: ComponentContext
) : FavouritesComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore { favouritesStoreFactory.create() }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is FavouritesStore.Label.CityItemClick -> onCityItemClicked(it.city)
                    FavouritesStore.Label.ClickSearch -> onSearchClicked()
                    FavouritesStore.Label.ClickToFavourite -> onAddToFavouriteClick()
                }
            }
        }

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<FavouritesStore.State> = store.stateFlow

    override fun onClickSearch() {
        store.accept(FavouritesStore.Intent.ClickSearch)
    }

    override fun onClickAddFavourite() {
        store.accept(FavouritesStore.Intent.ClickAddToFavourite)
    }

    override fun onCityItemClick(city: City) {
        store.accept(FavouritesStore.Intent.CityItemClick(city))
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("onCityItemClicked") onCityItemClicked: (City) -> Unit,
            @Assisted("onAddToFavouriteClick") onAddToFavouriteClick: () -> Unit,
            @Assisted("onSearchClicked") onSearchClicked: () -> Unit,
            @Assisted("componentContext") componentContext: ComponentContext
        ): DefaultFavouritesComponent
    }
}