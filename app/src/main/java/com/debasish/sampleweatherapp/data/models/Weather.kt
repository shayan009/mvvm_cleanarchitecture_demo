package com.debasish.sampleweatherapp.data.models

/*
"temp": 298.51,
"temp_min": 298.51,
"temp_max": 298.69,
"pressure": 1007,
"sea_level": 1007,
"grnd_level": 1004,
"humidity": 88,
"temp_kf": -0.18*/

data class Weather(var coord:Coord,var weather:List<Item>,var base:String,var main:Main,var visibility:String,var wind:Wind,var clouds:Clouds,var dt:Long,var sys:Sys,var id:Int,var name:String,var cod:Int)
data class Coord(var lon:Float,var lat:Float)
data class Main(var temp:Float,var pressure: Float,var humidity:Float,var temp_min:Float,var temp_max:Float,var sea_level:Long,var grnd_level:Long,var temp_kf:Float)
data class Wind(var speed:Float,var deg:Float)
data class Clouds(var all:Int)
data class Sys(var type:Int,var id:Long,var country: String,var sunrise:Long,var sunset:Long,var pod:String)
data class Item(var id:Int,var main:String,var description: String,var icon:String)