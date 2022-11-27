package com.br.douglasalipio.weatherfake.domain

import com.br.douglasalipio.weatherfake.features.weather.data.dtos.Parent
import com.br.douglasalipio.weatherfake.features.weather.data.dtos.WeatherInfoDto
import com.br.douglasalipio.weatherfake.features.weather.data.mappers.mapToDomain
import com.br.douglasalipio.weatherfake.features.weather.domain.FetchWeatherRepository
import com.br.douglasalipio.weatherfake.features.weather.domain.interactors.FetchWeatherInfoUseCase
import com.br.douglasalipio.weatherfake.features.weather.domain.states.FetchWeatherState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FetchWeatherInfoUseCaseTest {

    @MockK
    private lateinit var repositoryMock: FetchWeatherRepository
    private lateinit var fetchWeatherInfoUseCase: FetchWeatherInfoUseCase
    private val weatherInfoEntity = WeatherInfoDto(
        listOf(),
        Parent("title"),
        listOf(),
        "title",
        "location type",
        1
    ).mapToDomain()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        fetchWeatherInfoUseCase = FetchWeatherInfoUseCase(repositoryMock)
    }

    @Test
    fun `GIVEN locationId WHEN fetch weather use case is called THEN return SUCCESS state`() =
        runTest {
            //given
            val locationId = 111
            val params = FetchWeatherInfoUseCase.Params(locationId)
            coEvery { repositoryMock.fetchWeather(locationId) } returns weatherInfoEntity
            //when
            val expectedResult = fetchWeatherInfoUseCase.execute(params)
            //then
            assertEquals(expectedResult, FetchWeatherState.Success(weatherInfoEntity))
            coVerify(exactly = 1) { repositoryMock.fetchWeather(locationId) }

        }

    @Test
    fun `GIVEN locationId WHEN fetch weather use case is called THEN return FAIL state`() =
        runTest {
            //given
            val locationId = 111
            val params = FetchWeatherInfoUseCase.Params(locationId)
            coEvery { repositoryMock.fetchWeather(locationId) } throws Throwable()
            //when
            val expectedResult = fetchWeatherInfoUseCase.execute(params)
            //then
            assertEquals(expectedResult, FetchWeatherState.Fail)
            coVerify(exactly = 1) { repositoryMock.fetchWeather(locationId) }
        }
}