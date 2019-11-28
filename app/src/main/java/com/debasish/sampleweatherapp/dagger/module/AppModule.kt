package com.debasish.sampleweatherapp.dagger.module

import com.debasish.sampleweatherapp.data.IWeatherRepository
import com.debasish.sampleweatherapp.data.WeatherRepository
import com.debasish.sampleweatherapp.data.api.RetrofitAPI
import com.debasish.sampleweatherapp.utils.CustumViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import dagger.Module
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



@Module(includes = [ViewModelModule::class,ViewModelFactoryModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideCompositeDecomposible(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    public fun provideWeatherRepo( retrofitAPi: RetrofitAPI):IWeatherRepository{
        return WeatherRepository(retrofitAPi)
    }

    @Singleton
    @Provides
    public  fun provideRetrofit() :Retrofit {
       val baseUrl = "http://api.openweathermap.org/"
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return  Retrofit.Builder()
                .baseUrl(baseUrl)
                .client( OkHttpClient
                        .Builder()
                        .addInterceptor( HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .addNetworkInterceptor(interceptor)
                        .connectTimeout(6000, TimeUnit.SECONDS)
                        .readTimeout(600, TimeUnit.SECONDS)
                        .writeTimeout(600, TimeUnit.SECONDS)
                        .build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public fun provideRetrofitAPI(retrofit:Retrofit):RetrofitAPI{
         return retrofit.create(RetrofitAPI::class.java)
    }

}