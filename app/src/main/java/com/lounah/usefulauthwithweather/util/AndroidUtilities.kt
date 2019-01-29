package com.lounah.usefulauthwithweather.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


object AndroidUtilities {
    fun hideKeyboard(view: View?) {
        view?.let {
            val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (!imm.isActive) {
                return
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}