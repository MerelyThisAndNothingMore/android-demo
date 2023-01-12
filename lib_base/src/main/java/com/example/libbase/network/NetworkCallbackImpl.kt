package com.example.libbase.network

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
class NetworkCallbackImpl : ConnectivityManager.NetworkCallback() {

    private var currentType: NetworkType = NetworkType.OTHERS

    private var isConnected = false

    private var listeners: MutableList<NetworkStateChangeListener> = mutableListOf()

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        isConnected = true
        listeners.forEach {
            it.onConnectStateChange(isConnected)
        }
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        isConnected = false
        listeners.forEach {
            it.onConnectStateChange(isConnected)
        }
    }

    override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
            currentType = getNetworkType(networkCapabilities)
            listeners.forEach {
                it.onNetworkTypeChange(currentType)
            }
        }
    }

    fun addListener(listener: NetworkStateChangeListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: NetworkStateChangeListener) {
        listeners.remove(listener)
    }

    private fun getNetworkType(networkCapabilities: NetworkCapabilities): NetworkType {
        return when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> NetworkType.CELLULAR
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> NetworkType.WIFI
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> NetworkType.BLUETOOTH
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> NetworkType.ETHERNET
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> NetworkType.VPN
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI_AWARE) -> NetworkType.WIFI_AWARE
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_LOWPAN) -> NetworkType.LOWPAN
            else -> NetworkType.OTHERS
        }
    }
}