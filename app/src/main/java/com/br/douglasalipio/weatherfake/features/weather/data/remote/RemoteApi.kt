package com.br.douglasalipio.weatherfake.features.weather.data.remote

import com.br.douglasalipio.weatherfake.features.weather.data.dtos.WeatherInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {

    @GET("{location_id}.json")
    suspend fun fetchWeather(@Path("location_id") locationId: Int): WeatherInfoDto
}