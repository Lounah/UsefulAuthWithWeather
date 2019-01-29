package com.lounah.usefulauthwithweather.di.common.modules

import com.lounah.usefulauthwithweather.core.AppSchedulersProvider
import com.lounah.usefulauthwithweather.core.Mapper
import com.lounah.usefulauthwithweather.core.SchedulersProvider
import com.lounah.usefulauthwithweather.core.Validator
import com.lounah.usefulauthwithweather.data.entity.WeatherBean
import com.lounah.usefulauthwithweather.domain.weather.WeatherBeanToWeatherMapper
import com.lounah.usefulauthwithweather.domain.weather.entity.Weather
import com.lounah.usefulauthwithweather.presentation.authentication.util.validator.CredentialsState
import com.lounah.usefulauthwithweather.presentation.authentication.util.validator.CredentialsValidator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideAppScheduler(): SchedulersProvider = AppSchedulersProvider()

    @Provides
    @Singleton
    fun provideCredentialsValidator(): Validator<Pair<String, String>, CredentialsState> = CredentialsValidator()

    @Provides
    @Singleton
    fun provideWeatherBeanToWeatherObjMapper(): Mapper<WeatherBean, Weather> = WeatherBeanToWeatherMapper()
}