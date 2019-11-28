package com.debasish.sampleweatherapp

import android.app.Activity
import android.app.Application
import com.debasish.sampleweatherapp.dagger.component.AppComponent
import com.debasish.sampleweatherapp.dagger.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MainApp :Application() {


    companion object{
        public lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
         appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

}