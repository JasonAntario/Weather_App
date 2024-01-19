package com.dsankovsky.weatherapp.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.dsankovsky.weatherapp.presentation.details.DetailsComponent
import com.dsankovsky.weatherapp.presentation.favourites.FavouritesComponent
import com.dsankovsky.weatherapp.presentation.search.SearchComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {
        data class Favourite(val component: FavouritesComponent) : Child
        data class Details(val component: DetailsComponent) : Child
        data class Search(val component: SearchComponent) : Child
    }
}