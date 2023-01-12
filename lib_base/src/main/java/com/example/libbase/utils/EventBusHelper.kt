package com.example.libbase.utils

import org.greenrobot.eventbus.EventBus

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
object EventBusHelper {

    fun register(subscriber: Any) {
        EventBus.getDefault().register(subscriber)
    }

    fun unRegister(subscriber: Any) {
        EventBus.getDefault().unregister(subscriber)
    }

    fun postEvent(event: Any) {
        EventBus.getDefault().post(event)
    }


}