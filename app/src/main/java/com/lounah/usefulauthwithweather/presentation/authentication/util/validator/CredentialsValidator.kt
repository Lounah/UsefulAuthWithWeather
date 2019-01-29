package com.lounah.usefulauthwithweather.presentation.authentication.util.validator

import com.lounah.usefulauthwithweather.core.Validator
import java.util.regex.Pattern

class CredentialsValidator : Validator<Pair<String, String>, CredentialsState> {
    override fun verify(credentials: Pair<String, String>): CredentialsState {
        return when {
            emailIsOk(credentials.first) and !passwordIsOk(credentials.second) -> CredentialsState.INVALID_PASSWORD
            !emailIsOk(credentials.first) and passwordIsOk(credentials.second) -> CredentialsState.INVALID_USERNAME
            !emailIsOk(credentials.first) and !passwordIsOk(credentials.second) -> CredentialsState.INVALID_CREDENTIALS
            else -> CredentialsState.OK
        }
    }

    private fun emailIsOk(email: String): Boolean {
        val ePattern =
                "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
        val p = Pattern.compile(ePattern)
        val m = p.matcher(email)
        return m.matches()
    }

    private fun passwordIsOk(password: String): Boolean {
        val ePattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+\$).{6,}\$"
        val p = Pattern.compile(ePattern)
        val m = p.matcher(password)
        return m.matches()
    }
}

enum class CredentialsState {
    OK,
    INVALID_USERNAME,
    INVALID_PASSWORD,
    INVALID_CREDENTIALS
}