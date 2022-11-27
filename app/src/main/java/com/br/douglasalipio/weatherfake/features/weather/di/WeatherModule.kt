package com.br.douglasalipio.weatherfake.features.weather.di

import com.br.douglasalipio.weatherfake.features.weather.data.FetchWeatherRepositoryImp
import com.br.douglasalipio.weatherfake.features.weather.data.remote.RemoteService
import com.br.douglasalipio.weatherfake.features.weather.domain.FetchWeatherRepository
import com.br.douglasalipio.weatherfake.features.weather.domain.interactors.FetchWeatherInfoUseCase
import com.br.douglasalipio.weatherfake.features.weather.presentation.viewmodels.FetchWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object WeatherModule {

    val dataModule = module {
        single { RemoteService.create() }
        single<FetchWeatherRepository> { FetchWeatherRepositoryImp(get()) }
    }

    val domainModule = module {
        factory { FetchWeatherInfoUseCase(get()) }
    }

    val presentationModule = module {
        viewModel { FetchWeatherViewModel(get()) }
    }

}