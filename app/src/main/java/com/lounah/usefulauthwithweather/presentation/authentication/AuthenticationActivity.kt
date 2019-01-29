package com.lounah.usefulauthwithweather.presentation.authentication

import android.os.Bundle
import com.lounah.usefulauthwithweather.R
import com.lounah.usefulauthwithweather.presentation.authentication.login.LoginFragment
import com.lounah.usefulauthwithweather.presentation.common.BaseActivity

class AuthenticationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        setUpBaseFragment()
    }

    private fun setUpBaseFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_main, LoginFragment())
                .commit()
    }
}
