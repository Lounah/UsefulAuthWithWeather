package com.lounah.usefulauthwithweather.di.common

import com.lounah.usefulauthwithweather.app.UsefulAuthWithWeatherApplication

object AppInjector {
    fun init(app: UsefulAuthWithWeatherApplication) {
        DaggerAppComponent
                .builder()
                .application(app)
                .appContext(app)
                .build()
                .inject(app)
    }
}