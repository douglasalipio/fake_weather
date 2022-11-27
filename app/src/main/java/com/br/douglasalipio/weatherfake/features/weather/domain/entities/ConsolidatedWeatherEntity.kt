package com.br.douglasalipio.weatherfake.features.weather.domain.entities

import com.google.gson.annotations.SerializedName


data class ConsolidatedWeatherEntity(
    val id: Long,
    @SerializedName("weather_state_name")
    var weatherStateName: String,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String,
    @SerializedName("min_temp")
    val minTemp: Double,
    @SerializedName("max_temp")
    val maxTemp: Double,
    @SerializedName("the_temp")
    val theTemp: Double
)

