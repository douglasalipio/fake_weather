package com.br.douglasalipio.weatherfake.features.weather.presentation.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.br.douglasalipio.weatherfake.R
import com.br.douglasalipio.weatherfake.databinding.FragmentFetchWeatherBinding
import com.br.douglasalipio.weatherfake.features.weather.data.remote.RemoteService.ICON_BASE_URL
import com.br.douglasalipio.weatherfake.features.weather.domain.entities.WeatherInfoEntity
import com.br.douglasalipio.weatherfake.features.weather.presentation.actions.FetchWeatherAction
import com.br.douglasalipio.weatherfake.features.weather.presentation.viewmodels.FetchWeatherViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class FetchWeatherFragment : Fragment(R.layout.fragment_fetch_weather) {

    private val viewBinding by viewBinding(FragmentFetchWeatherBinding::bind)
    private val viewModel: FetchWeatherViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpEvents()
        viewModel.loadWeatherList(4418)
    }

    private fun setUpEvents() {
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is FetchWeatherAction.Loaded -> showWeatherInfo(state.weatherInfo)
                is FetchWeatherAction.Loading -> showProgressIndicator(View.VISIBLE)
                is FetchWeatherAction.Fail -> showErrorMessage()
            }
        }
    }

    private fun showWeatherInfo(weatherInfo: WeatherInfoEntity) {
        showProgressIndicator(View.INVISIBLE)
        viewBinding.cityNameText.text = weatherInfo.title
        viewBinding.currentTemperature.text =
            "${weatherInfo.consolidated_weather.last().theTemp.toInt()}°"
        viewBinding.minTemperature.text =
            "Min - ${weatherInfo.consolidated_weather.last().minTemp.toInt()}°"
        viewBinding.maxTemperature.text =
            "Max - ${weatherInfo.consolidated_weather.last().maxTemp.toInt()}°"
        viewBinding.weatherState.text = weatherInfo.consolidated_weather.last().weatherStateName
        Picasso.get()
            .load("$ICON_BASE_URL${weatherInfo.consolidated_weather.last().weatherStateAbbr}.png")
            .into(viewBinding.weatherIcon)
    }


    private fun showErrorMessage() {
        showProgressIndicator(View.INVISIBLE)
        Snackbar.make(
            viewBinding.fetchWeatherCoordinatorLayout,
            getString(R.string.fetch_weather_info_erro_message),
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun showProgressIndicator(hasVisibility: Int) {
        viewBinding.fetchWeatherProgress.visibility = hasVisibility
    }

}