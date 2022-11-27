package com.br.douglasalipio.weatherfake.features.weather.data.dtos


data class Source(
    val title: String,
    val slug: String,
    val url: String,
    val crawl_rate: Int
)