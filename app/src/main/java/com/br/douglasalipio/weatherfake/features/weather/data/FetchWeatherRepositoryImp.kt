package com.br.douglasalipio.weatherfake.features.weather.data

import com.br.douglasalipio.weatherfake.features.weather.data.mappers.mapToDomain
import com.br.douglasalipio.weatherfake.features.weather.data.remote.RemoteApi
import com.br.douglasalipio.weatherfake.features.weather.domain.FetchWeatherRepository
import com.br.douglasalipio.weatherfake.features.weather.domain.entities.WeatherInfoEntity

class FetchWeatherRepositoryImp(private val remoteApi: RemoteApi) : FetchWeatherRepository {

    override suspend fun fetchWeather(locationId: Int): WeatherInfoEntity =
        remoteApi.fetchWeather(locationId).mapToDomain()
}