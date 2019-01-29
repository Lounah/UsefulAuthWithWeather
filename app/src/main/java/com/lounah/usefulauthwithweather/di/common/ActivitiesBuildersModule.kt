package com.lounah.usefulauthwithweather.di.common

import com.lounah.usefulauthwithweather.di.application.AppFragmentInjectorBuilders
import com.lounah.usefulauthwithweather.presentation.authentication.AuthenticationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesBuildersModule {
    @ContributesAndroidInjector(modules = [
        AppFragmentInjectorBuilders::class
    ]
    )
    fun provideAuthenticationActivity(): AuthenticationActivity
}