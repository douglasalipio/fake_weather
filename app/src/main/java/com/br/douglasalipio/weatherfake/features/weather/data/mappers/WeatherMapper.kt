package com.br.douglasalipio.weatherfake.features.weather.data.mappers

import com.br.douglasalipio.weatherfake.features.weather.data.dtos.ConsolidatedWeather
import com.br.douglasalipio.weatherfake.features.weather.data.dtos.Parent
import com.br.douglasalipio.weatherfake.features.weather.data.dtos.Source
import com.br.douglasalipio.weatherfake.features.weather.data.dtos.WeatherInfoDto
import com.br.douglasalipio.weatherfake.features.weather.domain.entities.ConsolidatedWeatherEntity
import com.br.douglasalipio.weatherfake.features.weather.domain.entities.ParentEntity
import com.br.douglasalipio.weatherfake.features.weather.domain.entities.SourceEntity
import com.br.douglasalipio.weatherfake.features.weather.domain.entities.WeatherInfoEntity

fun WeatherInfoDto.mapToDomain() =
    WeatherInfoEntity(
        consolidated_weather = this.consolidated_weather.mapConsolidatedWeatherToDomain(),
        parent = this.parent.mapParentToDomain(),
        sources = this.sources.mapSourceToDomain(),
        title = this.title,
        locationType = this.locationType,
        woeid = this.woeid
    )

fun List<ConsolidatedWeather>.mapConsolidatedWeatherToDomain() = map {
    ConsolidatedWeatherEntity(
        id = it.id,
        weatherStateName = it.weatherStateName,
        weatherStateAbbr = it.weatherStateAbbr,
        minTemp = it.minTemp,
        maxTemp = it.maxTemp,
        theTemp = it.theTemp
    )
}

fun Parent.mapParentToDomain() = ParentEntity(title = this.title)

fun List<Source>.mapSourceToDomain() = map {
    SourceEntity(title = it.title, slug = it.slug, url = it.url, crawl_rate = it.crawl_rate)
}