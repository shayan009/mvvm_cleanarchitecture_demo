package com.debasish.sampleweatherapp.dagger.module

import androidx.lifecycle.ViewModelProvider
import com.debasish.sampleweatherapp.utils.CustumViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: CustumViewModelFactory): ViewModelProvider.Factory
}