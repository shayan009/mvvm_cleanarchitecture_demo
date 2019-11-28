package com.debasish.sampleweatherapp.dagger.component

import android.app.Application
import com.debasish.sampleweatherapp.MainApp
import com.debasish.sampleweatherapp.presentation.home.MainActivity
import com.debasish.sampleweatherapp.dagger.module.AppModule
import com.debasish.sampleweatherapp.presentation.weather_report.WeatherDetailsActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
 interface AppComponent {
     fun inject(mainActivity: MainActivity)
     fun inject(weatherActivity: WeatherDetailsActivity)
     @Component.Builder
     interface Builder{
          @BindsInstance
          fun application(application: Application): Builder
          fun build(): AppComponent
     }
}