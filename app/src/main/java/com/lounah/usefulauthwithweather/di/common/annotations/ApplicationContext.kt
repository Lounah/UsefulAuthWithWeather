package com.lounah.usefulauthwithweather.di.common.annotations

import javax.inject.Qualifier

@Target(AnnotationTarget.VALUE_PARAMETER)
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext