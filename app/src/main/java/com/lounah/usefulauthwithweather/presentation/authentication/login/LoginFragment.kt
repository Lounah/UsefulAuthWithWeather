package com.lounah.usefulauthwithweather.presentation.authentication.login

import android.arch.lifecycle.Observer
import android.view.View
import com.lounah.usefulauthwithweather.R
import com.lounah.usefulauthwithweather.presentation.authentication.util.validator.CredentialsState
import com.lounah.usefulauthwithweather.presentation.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : BaseFragment() {
    override val TAG = "login fragment"
    override val layoutRes = R.layout.fragment_login

    @Inject
    lateinit var viewModel: LoginFragmentViewModel

    override fun initUI() {
        initViewModelObservers()
        setUpLoginButton()
        setUpRegistrationButton()
    }

    private fun initViewModelObservers() {
        viewModel.errorState.observe(this, Observer { error ->
            error?.let {
                showToast(R.string.error_fetching_weather)
            }
        })

        viewModel.loadingState.observe(this, Observer { isLoading ->
            isLoading?.let {shouldShowLoading ->
                if (shouldShowLoading) {
                    view_login_loading.visibility = View.VISIBLE
                } else {
                    view_login_loading.visibility = View.GONE
                }
            }
        })

        viewModel.currentCredentialsState.observe(this, Observer { state ->
            state?.let {
                handleCredentialsState(it)
            }
        })

        viewModel.weather.observe(this, Observer { weather ->
            weather?.let {
                showSnackBar(root_fragment_login, String.format(resources.getString(R.string.weather_snack), weather.temp))
            }
        })
    }

    private fun setUpLoginButton() {
        clearErrorFields()
        btn_log_in.setOnClickListener {
            viewModel.updateCredentials(et_email.text.toString(), et_password.text.toString())
        }
    }

    private fun setUpRegistrationButton() {
        // ignore...
    }

    private fun handleCredentialsState(credentialsState: CredentialsState) {
        when(credentialsState) {
            CredentialsState.INVALID_CREDENTIALS -> {
                et_email.error = resources.getString(R.string.invalid_username)
                et_password.error = resources.getString(R.string.invalid_password)
            }
            CredentialsState.INVALID_PASSWORD -> {
                clearErrorFields()
                et_password.error = resources.getString(R.string.invalid_password)
            }
            CredentialsState.INVALID_USERNAME -> {
                clearErrorFields()
                et_email.error = resources.getString(R.string.invalid_username)
            }
        }
    }

    private fun clearErrorFields() {
        et_email.error = null
        et_password.error = null
    }
}