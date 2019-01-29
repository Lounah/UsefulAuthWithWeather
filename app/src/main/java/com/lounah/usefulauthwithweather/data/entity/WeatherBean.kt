package com.lounah.usefulauthwithweather.data.entity

import com.google.gson.annotations.SerializedName

/**
 *  Actually, i think that bean is not an entity, so it should be in datasource/remote package.
 */

data class WeatherBean(
        @SerializedName("coord") val coordinates: Coord,
        val weather: Array<Weather>,
        val base: String,
        val main: Main,
        val visibility: Int,
        val wind: Wind,
        val clouds: Clouds,
        val dt: Long,
        val sys: Sys,
        val id: Long,
        val name: String,
        val cod: Int
)

data class Weather(
        val id: String = "",
        val main: String = "",
        val description: String = "",
        val icon: String = ""
)

data class Coord(
        @SerializedName("lon") val lng: Double = 0.0,
        @SerializedName("lat") val ltd: Double = 0.0
)

data class Main(
        val temp: Double = 0.0,
        val pressure: Int = 0,
        val humidity: Int = 0,
        @SerializedName("temp_min") val tempMin: Double = 0.0,
        @SerializedName("temp_max") val tempMax: Double = 0.0
)

data class Wind(
        val speed: Double = 0.0
)

data class Clouds(
        val all: Double = 0.0
)

data class Sys(
        val type: Int,
        val id: Long,
        val message: Double,
        val country: String,
        val sunrise: Long,
        val sunset: Long
)