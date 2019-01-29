package com.lounah.usefulauthwithweather.util

import android.content.Context
import android.text.method.PasswordTransformationMethod
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

    object BiggerDotPasswordTransformationMethod : PasswordTransformationMethod() {

        override fun getTransformation(source: CharSequence, view: View): CharSequence {
            return PasswordCharSequence(super.getTransformation(source, view))
        }

        private class PasswordCharSequence(
                val transformation: CharSequence
        ) : CharSequence by transformation {
            override fun get(index: Int): Char = if (transformation[index] == DOT) {
                BIGGER_DOT
            } else {
                transformation[index]
            }
        }

        private const val DOT = '\u2022'
        private const val BIGGER_DOT = '●'
    }
}