package com.lounah.usefulauthwithweather.di.application

import com.lounah.usefulauthwithweather.data.repositories.WeatherRepositoryImpl
import com.lounah.usefulauthwithweather.domain.weather.WeatherRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ImplementationBindingModule {
    @Singleton
    @Binds
    abstract fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository
}