package com.debasish.sampleweatherapp.presentation.weather_report

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.debasish.sampleweatherapp.MainApp
import com.debasish.sampleweatherapp.R
import com.debasish.sampleweatherapp.utils.CustumViewModelFactory
import com.debasish.sampleweatherapp.utils.getDate
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_weather_details.*
import javax.inject.Inject

class WeatherDetailsActivity : AppCompatActivity() {

    private var weatherViewModel: WeatherDetailViewModel? = null

    @Inject
    public lateinit var viewModelFactory : CustumViewModelFactory
    var compositeDisposable=CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)
        MainApp.appComponent.inject(this)
        weatherViewModel = ViewModelProviders.of(this,viewModelFactory).get(WeatherDetailViewModel::class.java)
        tvTitleWD.text=intent.getStringExtra("city_name")
        weatherViewModel?.getCurrentWeatherDetails(intent.getStringExtra("city_name"))

            ?.subscribe({ t1 ->
                if(t1!=null){
                    Log.d("VmWeather",t1.toString())
                    tvDateTime.text= t1?.dt?.let { getDate(it,"MMMM dd,yyyy HH:mm a") }
                    tvTemp.text=(t1?.main?.temp?.minus(273.15))?.round(2).toString()
                    tvMaxTemp.text="Day "+(t1?.main?.temp_max?.minus(273.15)?.round(2).toString()).toString()
                    tvMinTemp.text="Night "+(t1?.main?.temp_min?.minus(273.15)?.round(2).toString()).toString()
                    tvWeather.text=t1?.weather!![0].main
                    tvWeatherDesc.text=t1.weather[0].description
                    Glide.with(this)
                        .load("http://openweathermap.org/img/wn/"+t1.weather[0].icon+"@2x.png")
                        .into(ivWeatherIcon)
                    tvHumidityValue.text=t1.main.humidity.toString()+"%"
                    tvPressureValue.text=t1.main.pressure.div(100).toDouble().round(2).toString()+"Pa"
                    tvVisibilityValue.text=t1.visibility.toString()
                    tvWindSpeed.text=t1.wind.speed.toString()+"mph"
                    tvSunRiseTime.text=t1?.sys.sunrise?.let { getDate(it,"HH:mm a") }
                    tvSunSetTime.text=t1?.sys.sunset?.let { getDate(it,"HH:mm a") }


                    //http://openweathermap.org/img/wn/04n@2x.png
                }

            },{
                it.printStackTrace()
            })?.let { compositeDisposable.add(it) }
    }

    fun Double.round(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()
}
