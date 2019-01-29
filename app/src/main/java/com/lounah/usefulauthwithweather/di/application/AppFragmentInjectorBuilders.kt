package com.lounah.usefulauthwithweather.di.application

import com.lounah.usefulauthwithweather.presentation.authentication.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppFragmentInjectorBuilders {
    @ContributesAndroidInjector
    fun provideLoginFragment(): LoginFragment
}