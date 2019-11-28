package com.debasish.sampleweatherapp.domain

import com.debasish.sampleweatherapp.data.IWeatherRepository
import com.debasish.sampleweatherapp.data.WeatherRepository
import com.debasish.sampleweatherapp.data.models.Weather
import com.debasish.sampleweatherapp.domain.mapper.WeatherMapper
import com.debasish.sampleweatherapp.presentation.weather_report.VMHourlyData
import com.debasish.sampleweatherapp.presentation.weather_report.VMWeather
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
public class WeatherDetailsUseCase @Inject constructor(private val weatherRepository: IWeatherRepository){

    fun fetchWeatherDetails(cityName:String):Single<VMWeather>{
    return weatherRepository.fetchWeatherDetails(cityName)
    .map { WeatherMapper.toVM(it) }
    .observeOn(AndroidSchedulers.mainThread())
    }

    fun fetchCurrentWeatherDetails(cityName:String):Single<VMHourlyData>{
        return weatherRepository.fetchCurrentWeatherDetails(cityName)
            .map { WeatherMapper.toVMHourlyData(it) }
            .observeOn(AndroidSchedulers.mainThread())
    }
}
