package com.br.douglasalipio.weatherfake.features.weather.presentation.actions

import com.br.douglasalipio.weatherfake.features.weather.domain.entities.WeatherInfoEntity

sealed class FetchWeatherAction {
    object Loading : FetchWeatherAction()
    object Fail : FetchWeatherAction()
    data class Loaded(val weatherInfo: WeatherInfoEntity) : FetchWeatherAction()
}