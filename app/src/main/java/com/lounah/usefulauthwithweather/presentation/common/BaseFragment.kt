package com.lounah.usefulauthwithweather.presentation.common

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View?
            = inflater.inflate(layoutRes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    protected fun showToast(msgId: Int) {
        Toast.makeText(context, msgId, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showSnackBar(rootView: View, msgId: Int) {
        Snackbar.make(rootView, msgId, Snackbar.LENGTH_LONG).show()
    }

    protected fun showSnackBar(rootView: View, msg: String) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_LONG).show()
    }

    abstract fun initUI()
    abstract val TAG : String
    abstract val layoutRes : Int
}