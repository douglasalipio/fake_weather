package com.br.douglasalipio.weatherfake.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.br.douglasalipio.weatherfake.features.weather.data.dtos.Parent
import com.br.douglasalipio.weatherfake.features.weather.data.dtos.WeatherInfoDto
import com.br.douglasalipio.weatherfake.features.weather.data.mappers.mapToDomain
import com.br.douglasalipio.weatherfake.features.weather.domain.interactors.FetchWeatherInfoUseCase
import com.br.douglasalipio.weatherfake.features.weather.domain.states.FetchWeatherState
import com.br.douglasalipio.weatherfake.features.weather.presentation.actions.FetchWeatherAction
import com.br.douglasalipio.weatherfake.features.weather.presentation.viewmodels.FetchWeatherViewModel
import com.br.douglasalipio.weatherfake.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class FetchWeatherInfoViewModelTest {

    @MockK
    lateinit var fetchWeatherInfoUseCaseMock: FetchWeatherInfoUseCase

    private lateinit var fetchWeatherViewModel: FetchWeatherViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

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
        fetchWeatherViewModel = FetchWeatherViewModel(fetchWeatherInfoUseCaseMock)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun `GIVEN locationId WHEN load weather info THEN return LOADED view state`() = runTest {
        //given
        val locationId = 444
        val params = FetchWeatherInfoUseCase.Params(locationId)
        coEvery { fetchWeatherInfoUseCaseMock.execute(params) } returns FetchWeatherState.Success(
            weatherInfoEntity
        )
        //when
        fetchWeatherViewModel.loadWeatherList(locationId)
        advanceUntilIdle()
        //then
        assertEquals(
            FetchWeatherAction.Loaded(weatherInfoEntity),
            fetchWeatherViewModel.viewState.getOrAwaitValue()
        )
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
    }
}