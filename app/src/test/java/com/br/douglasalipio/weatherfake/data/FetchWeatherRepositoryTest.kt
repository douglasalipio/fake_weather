package com.br.douglasalipio.weatherfake.data

import com.br.douglasalipio.weatherfake.features.weather.data.FetchWeatherRepositoryImp
import com.br.douglasalipio.weatherfake.features.weather.data.dtos.Parent
import com.br.douglasalipio.weatherfake.features.weather.data.dtos.WeatherInfoDto
import com.br.douglasalipio.weatherfake.features.weather.data.mappers.mapToDomain
import com.br.douglasalipio.weatherfake.features.weather.data.remote.RemoteApi
import com.br.douglasalipio.weatherfake.features.weather.domain.FetchWeatherRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FetchWeatherRepositoryTest {

    @MockK
    private lateinit var remoteApiMock: RemoteApi

    private lateinit var repository: FetchWeatherRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = FetchWeatherRepositoryImp(remoteApiMock)
    }


    @Test
    fun `GIVEN location id WHEN fetch weather is called THEN return weather information data`()  = runTest{
        //given
        val locationId = 10
        val weatherInfoDto =
            WeatherInfoDto(listOf(), Parent("title"), listOf(), "title", "location type", 1)

        //when
        coEvery { remoteApiMock.fetchWeather(locationId) } returns weatherInfoDto
        val weatherInfoEntity = repository.fetchWeather(locationId)

        //then
        coVerify(exactly = 1) { remoteApiMock.fetchWeather(locationId) }
        assertNotNull(weatherInfoEntity)
    }
}