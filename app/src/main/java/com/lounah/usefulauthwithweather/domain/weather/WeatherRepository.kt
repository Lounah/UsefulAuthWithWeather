package com.lounah.usefulauthwithweather.domain.weather

import io.reactivex.Single

interface WeatherRepository {
    fun fetchWeather(): Single<WeatherBean>
}