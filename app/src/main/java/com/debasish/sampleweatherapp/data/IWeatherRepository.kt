package com.debasish.sampleweatherapp.data

import com.debasish.sampleweatherapp.data.models.HourlyWeatherResponse
import com.debasish.sampleweatherapp.data.models.Weather
import com.debasish.sampleweatherapp.presentation.weather_report.HourlyData
import io.reactivex.Single

interface IWeatherRepository {
    fun fetchWeatherDetails(cityName:String):Single<HourlyWeatherResponse>
    fun fetchCurrentWeatherDetails(cityName: String): Single<HourlyData>
}