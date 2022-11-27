package com.br.douglasalipio.weatherfake.features.weather.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.douglasalipio.weatherfake.features.weather.domain.interactors.FetchWeatherInfoUseCase
import com.br.douglasalipio.weatherfake.features.weather.domain.states.FetchWeatherState
import com.br.douglasalipio.weatherfake.features.weather.presentation.actions.FetchWeatherAction
import kotlinx.coroutines.launch

class FetchWeatherViewModel(private val fetchWeatherInfoUseCase: FetchWeatherInfoUseCase) : ViewModel() {

    val viewState = MutableLiveData<FetchWeatherAction>()

    fun loadWeatherList(locationId: Int) {
        viewModelScope.launch {
            val params = FetchWeatherInfoUseCase.Params(locationId)
            viewState.value = FetchWeatherAction.Loading
            fetchWeatherInfoUseCase.execute(params).handleFetchWeatherState()
        }
    }

    private fun FetchWeatherState.handleFetchWeatherState() {
        when (this) {
            is FetchWeatherState.Success -> viewState.value = FetchWeatherAction.Loaded(weatherList)
            is FetchWeatherState.Fail -> viewState.value = FetchWeatherAction.Fail
        }
    }

}