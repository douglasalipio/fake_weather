package com.br.douglasalipio.weatherfake.features.weather.domain.entities

import com.google.gson.annotations.SerializedName

data class WeatherInfoEntity(
    val consolidated_weather: List<ConsolidatedWeatherEntity>,
    val parent: ParentEntity,
    val sources: List<SourceEntity>,
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    val woeid: Int,
)