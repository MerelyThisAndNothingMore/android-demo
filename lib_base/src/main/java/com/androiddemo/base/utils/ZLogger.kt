package com.androiddemo.base.utils

import android.util.Log

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
object ZLogger {

    fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }

    fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }

    fun v(tag: String, msg: String) {
        Log.v(tag, msg)
    }

}