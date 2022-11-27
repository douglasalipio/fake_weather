package com.br.douglasalipio.weatherfake.features.weather.data.dtos

import com.google.gson.annotations.SerializedName

data class WeatherInfoDto(
    val consolidated_weather: List<ConsolidatedWeather>,
    val parent: Parent,
    val sources: List<Source>,
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    val woeid: Int,
)