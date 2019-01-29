package com.lounah.usefulauthwithweather.data.repositories

import com.lounah.usefulauthwithweather.data.datasource.remote.WeatherApi
import com.lounah.usefulauthwithweather.data.entity.WeatherBean
import com.lounah.usefulauthwithweather.domain.weather.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi) : WeatherRepository {
    override fun fetchWeather(): Single<WeatherBean> = weatherApi.fetchWeather()
}