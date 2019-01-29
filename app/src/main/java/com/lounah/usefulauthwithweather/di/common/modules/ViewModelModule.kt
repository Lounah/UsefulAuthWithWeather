package com.lounah.usefulauthwithweather.di.common.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.lounah.usefulauthwithweather.di.common.annotations.ViewModelKey
import com.lounah.usefulauthwithweather.presentation.authentication.login.LoginFragmentViewModel
import com.lounah.usefulauthwithweather.presentation.common.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginFragmentViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginFragmentViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}