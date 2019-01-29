package com.lounah.usefulauthwithweather

import com.lounah.usefulauthwithweather.presentation.authentication.util.validator.CredentialsState
import com.lounah.usefulauthwithweather.presentation.authentication.util.validator.CredentialsValidator
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CredentialsVerifierText {

    private val invalidEmails = listOf("abc", "abc@", "abc@d", "abc@d.", "abc,@gmail.com")
    private val invalidPasswords = listOf("abc", "abcdef", "abcd1", "AAAAAA1")
    private val validEmail = "lounah@yandex.ru"
    private val validPasswod = "SomeStrongPassword1"

    private val credentialsVerifier = CredentialsValidator()

    @Test
    fun typeInvalidEmailValidPasswordShowsError() {
        invalidEmails.forEach {
            val credentials = Pair(it, validPasswod)
            assertThat(credentialsVerifier.verify(credentials), `is`(CredentialsState.INVALID_USERNAME))
        }
    }

    @Test
    fun typeValidEmailInValidPasswordShowsError() {
        invalidPasswords.forEach {
            val credentials = Pair(validEmail, it)
            assertThat(credentialsVerifier.verify(credentials), `is`(CredentialsState.INVALID_PASSWORD))
        }
    }

    @Test
    fun typeInValidEmailInValidPasswordShowsError() {
        invalidPasswords.forEach { someInvalidPassword ->
            invalidEmails.forEach { someInvalidEmail ->
                val credentials = Pair(someInvalidEmail, someInvalidPassword)
                assertThat(credentialsVerifier.verify(credentials), `is`(CredentialsState.INVALID_CREDENTIALS))
            }
        }
    }

    @Test
    fun typeAllValidShowsOk() {
        val credentials = Pair(validEmail, validPasswod)
        assertThat(credentialsVerifier.verify(credentials), `is`(CredentialsState.OK))
    }
}