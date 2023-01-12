package com.example.libbase.utils

import android.os.Looper

/****
 * @author : zhangjin.rolling
 * @date : 星期四 2023/1/12
 */
object MainThreadUtil {

    fun isInMainThread(): Boolean {
        return Looper.getMainLooper() == Looper.myLooper()
    }
}