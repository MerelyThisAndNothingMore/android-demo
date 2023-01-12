package com.example.libbase.network

import androidx.lifecycle.*

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
class NetworkListenAutoSetter constructor(val listener: NetworkStateChangeListener) : LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_RESUME -> {
                NetworkListenHelper.addListener(listener)
            }
            Lifecycle.Event.ON_PAUSE -> {
                NetworkListenHelper.removeListener(listener)
            }
            Lifecycle.Event.ON_DESTROY -> {
                NetworkListenHelper.removeListener(listener)
            }
            else -> {}
        }
    }


}