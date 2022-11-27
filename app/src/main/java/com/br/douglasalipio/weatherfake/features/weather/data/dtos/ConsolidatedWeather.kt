package com.br.douglasalipio.weatherfake.features.weather.data.dtos

import com.google.gson.annotations.SerializedName


data class ConsolidatedWeather(
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

