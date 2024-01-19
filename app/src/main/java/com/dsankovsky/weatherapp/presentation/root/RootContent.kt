package com.dsankovsky.weatherapp.presentation.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.dsankovsky.weatherapp.presentation.details.DetailsContent
import com.dsankovsky.weatherapp.presentation.favourites.FavouritesContent
import com.dsankovsky.weatherapp.presentation.search.SearchContent
import com.dsankovsky.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun RootContent(
    component: RootComponent
) {

    WeatherAppTheme {
        Children(
            stack = component.stack
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.Details -> {
                    DetailsContent(component = instance.component)
                }

                is RootComponent.Child.Favourite -> {
                    FavouritesContent(component = instance.component)
                }

                is RootComponent.Child.Search -> {
                    SearchContent(component = instance.component)
                }
            }
        }
    }
}