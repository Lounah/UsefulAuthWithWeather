package com.lounah.usefulauthwithweather.domain.weather

import com.lounah.usefulauthwithweather.core.Mapper
import com.lounah.usefulauthwithweather.data.entity.WeatherBean
import com.lounah.usefulauthwithweather.domain.weather.entity.Weather
import io.reactivex.Single
import javax.inject.Inject

class WeatherInteractor @Inject constructor(private val weatherRepository: WeatherRepository,
                                            private val mapper: Mapper<WeatherBean, Weather>) {
    fun fetchWeather(): Single<Weather> = weatherRepository.fetchWeather().map { mapper.map(it) }
}