package com.debasish.sampleweatherapp.presentation.weather_report

import com.debasish.sampleweatherapp.data.models.*
import com.google.gson.annotations.SerializedName

data class VMWeather(var cnt:Int,var message:String,var cod:String,var list:List<HourlyData>)
data class HourlyData(var dt_txt:String,var sys: Sys,var wind: Wind,var clouds: Clouds,var weather:List<Item>,var main: Main,var dt:Long,var rain: Rain,var visibility:Long)
data class Rain( @SerializedName("3h") var hr:Float)