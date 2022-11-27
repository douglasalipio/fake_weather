package com.br.douglasalipio.weatherfake.features.weather.domain.states

import com.br.douglasalipio.weatherfake.features.weather.domain.entities.WeatherInfoEntity

sealed class FetchWeatherState {
    object Fail : FetchWeatherState()
    data class Success(val weatherList: WeatherInfoEntity) : FetchWeatherState()
}