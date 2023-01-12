package com.example.libbase.network

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
interface NetworkStateChangeListener {
    fun onNetworkTypeChange(networkType: NetworkType)

    fun onConnectStateChange(connecting: Boolean)
}