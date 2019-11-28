package com.debasish.sampleweatherapp.data

import com.debasish.sampleweatherapp.MainApp
import com.debasish.sampleweatherapp.data.api.RetrofitAPI
import com.debasish.sampleweatherapp.data.models.HourlyWeatherResponse
import com.debasish.sampleweatherapp.data.models.Weather
import com.debasish.sampleweatherapp.presentation.weather_report.HourlyData
import com.debasish.sampleweatherapp.utils.Constants
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherRepository(var retrofitAPi: RetrofitAPI)  :IWeatherRepository{



    override fun fetchWeatherDetails(cityName: String): Single<HourlyWeatherResponse> {
        val queryMap = HashMap<String, String>()
        cityName.let { queryMap.put(Constants.CITY_NAME, it) }
        "9385b5723b19750e3ec01d8103a82b23".let { queryMap.put(Constants.APPID, it) }
       return retrofitAPi.fetchHourlyWeather(queryMap).subscribeOn(Schedulers.io())
    }

    override fun fetchCurrentWeatherDetails(cityName: String): Single<HourlyData> {
        val queryMap = HashMap<String, String>()
        cityName.let { queryMap.put(Constants.CITY_NAME, it) }
        "9385b5723b19750e3ec01d8103a82b23".let { queryMap.put(Constants.APPID, it) }
        return retrofitAPi.fetchWeatherDetails(queryMap).subscribeOn(Schedulers.io())
    }
}