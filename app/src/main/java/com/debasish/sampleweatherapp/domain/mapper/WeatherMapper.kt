package com.debasish.sampleweatherapp.domain.mapper

import com.debasish.sampleweatherapp.data.models.*
import com.debasish.sampleweatherapp.presentation.weather_report.*
import com.debasish.sampleweatherapp.presentation.weather_report.HourlyData
import com.debasish.sampleweatherapp.presentation.weather_report.Rain
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

object  WeatherMapper {
    fun toVM(weatherMapper: HourlyWeatherResponse):VMWeather{

        val list= mutableListOf<HourlyData>()

        weatherMapper.list.forEach { item ->
            list.add(HourlyData(item.dt_txt,item.sys, item.wind, item.clouds,item.weather,item.main, item.dt,Rain(0.25f),item.visibility))
        }
          return  VMWeather(weatherMapper.cnt,weatherMapper.message,weatherMapper.cod,list)
        }

    fun toVMHourlyData(hourlyData: HourlyData):VMHourlyData{

        return  VMHourlyData("",hourlyData.sys, hourlyData.wind, hourlyData.clouds,hourlyData.weather,hourlyData.main, hourlyData.dt,Rain(0.25f),hourlyData.visibility)

    }
    }