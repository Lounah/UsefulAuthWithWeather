package com.lounah.usefulauthwithweather.di.common

import android.app.Application
import android.content.Context
import com.lounah.usefulauthwithweather.app.UsefulAuthWithWeatherApplication
import com.lounah.usefulauthwithweather.di.application.ImplementationBindingModule
import com.lounah.usefulauthwithweather.di.common.annotations.ApplicationContext
import com.lounah.usefulauthwithweather.di.common.modules.AppModule
import com.lounah.usefulauthwithweather.di.common.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivitiesBuildersModule::class,
    AppModule::class,
    NetworkModule::class,
    ImplementationBindingModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun appContext(@ApplicationContext context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: UsefulAuthWithWeatherApplication)
}