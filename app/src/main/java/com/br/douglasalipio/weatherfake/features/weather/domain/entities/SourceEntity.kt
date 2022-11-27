package com.br.douglasalipio.weatherfake.features.weather.domain.entities


data class SourceEntity(
    val title: String,
    val slug: String,
    val url: String,
    val crawl_rate: Int
)