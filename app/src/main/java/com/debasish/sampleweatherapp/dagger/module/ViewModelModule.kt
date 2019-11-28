package com.debasish.sampleweatherapp.dagger.module

import dagger.Module
import androidx.lifecycle.ViewModel
import com.debasish.sampleweatherapp.dagger.ViewModelKey
import com.debasish.sampleweatherapp.presentation.weather_report.WeatherDetailViewModel
import dagger.multibindings.IntoMap
import dagger.Binds



@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherDetailViewModel::class)
    abstract fun bindWeatherViewModel(weatherDetailViewModel: WeatherDetailViewModel): ViewModel

}