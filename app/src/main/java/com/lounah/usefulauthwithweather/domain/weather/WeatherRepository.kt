package com.lounah.usefulauthwithweather.domain.weather

import com.lounah.usefulauthwithweather.data.entity.WeatherBean
import io.reactivex.Single

interface WeatherRepository {
    fun fetchWeather(): Single<WeatherBean>
}