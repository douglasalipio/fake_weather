package com.br.douglasalipio.weatherfake.features.weather.domain

import com.br.douglasalipio.weatherfake.features.weather.domain.entities.WeatherInfoEntity

interface FetchWeatherRepository {

    suspend fun fetchWeather(locationId: Int): WeatherInfoEntity
}