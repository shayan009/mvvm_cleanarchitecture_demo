package com.debasish.sampleweatherapp.data.api

import com.debasish.sampleweatherapp.data.models.HourlyWeatherResponse
import com.debasish.sampleweatherapp.data.models.Weather
import com.debasish.sampleweatherapp.presentation.weather_report.HourlyData
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*
import java.util.HashMap

interface RetrofitAPI {

    @GET("data/2.5/weather")
    fun fetchWeatherDetails(@QueryMap imageUpload: HashMap<String, String>): Single<HourlyData>

    @GET("data/2.5/forecast")
    fun fetchHourlyWeather(@QueryMap imageUpload: HashMap<String, String>): Single<HourlyWeatherResponse>
}