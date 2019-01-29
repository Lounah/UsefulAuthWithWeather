package com.lounah.usefulauthwithweather.domain.weather

import com.lounah.usefulauthwithweather.core.Mapper
import com.lounah.usefulauthwithweather.domain.weather.entity.Weather

class WeatherBeanToWeatherMapper : Mapper<WeatherBean, Weather> {
    override fun map(arg: WeatherBean): Weather = Weather(arg.main.temp.toString())
}