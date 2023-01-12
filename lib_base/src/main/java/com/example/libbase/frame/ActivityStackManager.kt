package com.example.libbase.frame

import android.app.Activity
import java.util.*

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
object ActivityStackManager {

    private val activityStack by lazy { Stack<Activity>() }

    fun push(activity: Activity) {
        activityStack.add(activity)
    }

    fun remove(activity: Activity) {
        activityStack.remove(activity)
    }

    fun currentActivity(): Activity? {
        return if (activityStack.isNotEmpty()) {
            activityStack.lastElement()
        } else {
            null
        }
    }

}