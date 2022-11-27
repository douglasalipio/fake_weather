package com.br.douglasalipio.weatherfake.features.weather

import android.app.Application
import com.br.douglasalipio.weatherfake.features.weather.di.WeatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import org.koin.core.context.startKoin

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@WeatherApplication)
            modules(
                WeatherModule.dataModule,
                WeatherModule.domainModule,
                WeatherModule.presentationModule
            )
        }
    }

}