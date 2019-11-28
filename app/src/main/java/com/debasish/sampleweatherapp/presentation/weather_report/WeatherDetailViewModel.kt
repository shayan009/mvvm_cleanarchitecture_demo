package com.debasish.sampleweatherapp.presentation.weather_report

import androidx.lifecycle.ViewModel
import com.debasish.sampleweatherapp.domain.WeatherDetailsUseCase
import io.reactivex.Single
import javax.inject.Inject

public  class WeatherDetailViewModel @Inject constructor(private val weatherUserCase: WeatherDetailsUseCase) :ViewModel(){

    fun getWeatherDetails(cityName: String):Single<VMWeather>{
     return weatherUserCase.fetchWeatherDetails(cityName)
    }
    fun getCurrentWeatherDetails(cityName: String):Single<VMHourlyData>{
        return weatherUserCase.fetchCurrentWeatherDetails(cityName)
    }

}