package com.lounah.usefulauthwithweather.presentation.authentication.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.lounah.usefulauthwithweather.core.SchedulersProvider
import com.lounah.usefulauthwithweather.core.Validator
import com.lounah.usefulauthwithweather.domain.weather.WeatherInteractor
import com.lounah.usefulauthwithweather.domain.weather.entity.Weather
import com.lounah.usefulauthwithweather.presentation.authentication.util.validator.CredentialsState
import com.lounah.usefulauthwithweather.presentation.common.BaseViewModel
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor(
        private val credentialsValidator: Validator<Pair<String, String>, CredentialsState>,
        private val weatherInteractor: WeatherInteractor,
        private val rxSchedulersProvider: SchedulersProvider
) : BaseViewModel() {

    internal val weather = MutableLiveData<Weather>()

    internal val loadingState = MutableLiveData<Boolean>().apply {
        postValue(false)
    }

    internal val errorState = MutableLiveData<Throwable>()

    private val loginPasswordPair = MutableLiveData<Pair<String, String>>()

    internal val currentCredentialsState: LiveData<CredentialsState> =
            Transformations.switchMap(loginPasswordPair) { loginPassword ->
                MutableLiveData<CredentialsState>().apply {
                    val credentialsState = credentialsValidator.verify(loginPassword)
                    if (credentialsState == CredentialsState.OK && loadingState.value == false) {
                        getWeather()
                    }
                    postValue(credentialsState)
                }
            }

    internal fun updateCredentials(email: String, password: String) {
        loginPasswordPair.postValue(Pair(email, password))
    }

    private fun getWeather() {
        disposables.add(weatherInteractor.fetchWeather()
                .doOnSubscribe { loadingState.postValue(true) }
                .subscribeOn(rxSchedulersProvider.io())
                .observeOn(rxSchedulersProvider.ui())
                .subscribe({
                    weather.postValue(it)
                    loadingState.postValue(false)
                }, { error ->
                    errorState.postValue(error)
                    loadingState.postValue(false)
                })
        )
    }
}