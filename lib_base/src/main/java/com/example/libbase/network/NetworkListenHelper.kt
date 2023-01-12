package com.example.libbase.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkRequest
import androidx.annotation.RequiresPermission
import com.example.libbase.frame.BaseApplication

/****
 * network listen delegate
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
object NetworkListenHelper {

    private val networkCallback = NetworkCallbackImpl()

    @RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
    fun startListen() {
        val request = NetworkRequest.Builder().build()
        (BaseApplication.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .registerNetworkCallback(request, networkCallback)
    }

    fun addListener(listener: NetworkStateChangeListener) {
        networkCallback.addListener(listener)
    }

    fun removeListener(listener: NetworkStateChangeListener) {
        networkCallback.removeListener(listener)
    }
}