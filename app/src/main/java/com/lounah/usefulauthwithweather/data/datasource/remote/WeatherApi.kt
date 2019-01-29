package com.lounah.usefulauthwithweather.data.datasource.remote

import com.lounah.usefulauthwithweather.BuildConfig
import com.lounah.usefulauthwithweather.data.entity.WeatherBean
import io.reactivex.Single
import retrofit2.http.GET

interface WeatherApi {

    /**
     *  Args were hardcoded, but i don't think they're important for this task
     */

    @GET("data/2.5/weather?q=London,uk&units=metric&APPID=${BuildConfig.WEATHER_API_KEY}")
    fun fetchWeather(): Single<WeatherBean>
}