package com.br.douglasalipio.weatherfake.features.weather.domain.interactors

import com.br.douglasalipio.weatherfake.features.weather.domain.FetchWeatherRepository
import com.br.douglasalipio.weatherfake.features.weather.domain.states.FetchWeatherState

class FetchWeatherInfoUseCase(private val weatherRepository: FetchWeatherRepository) {

    suspend fun execute(params: Params) = try {
        val weatherInfo = weatherRepository.fetchWeather(params.locationId)
        FetchWeatherState.Success(weatherInfo)
    } catch (throwable: Throwable) {
        FetchWeatherState.Fail
    }

    data class Params(val locationId: Int)
}