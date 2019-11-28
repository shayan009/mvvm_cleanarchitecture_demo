package com.debasish.sampleweatherapp.presentation.weather_report

import com.debasish.sampleweatherapp.data.models.*

data class VMHourlyData(var dt_txt:String, var sys: Sys, var wind: Wind, var clouds: Clouds, var weather:List<Item>, var main: Main, var dt:Long, var rain: Rain,var visibility:Long)
