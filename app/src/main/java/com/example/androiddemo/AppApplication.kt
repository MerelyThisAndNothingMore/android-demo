package com.example.androiddemo

import com.example.libbase.frame.BaseApplication
import dagger.hilt.android.HiltAndroidApp
import org.greenrobot.eventbus.EventBus

/****
 * @author : zhangjin.rolling
 * @date : 星期一 2022/12/5
 */
@HiltAndroidApp
class AppApplication : BaseApplication() {

    override fun onCreate() {
        EventBus.builder().installDefaultEventBus()

        super.onCreate()
    }
}