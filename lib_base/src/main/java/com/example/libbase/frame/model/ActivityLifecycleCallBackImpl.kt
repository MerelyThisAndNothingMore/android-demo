package com.example.libbase.frame.model

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.example.libbase.frame.ActivityStackManager

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
class ActivityLifecycleCallBackImpl : Application.ActivityLifecycleCallbacks {

    companion object {
        private const val TAG = "ActivityLifecycle"
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        ActivityStackManager.push(p0)
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityCreated")
    }

    override fun onActivityStarted(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityStarted")
    }

    override fun onActivityResumed(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityResumed")
    }

    override fun onActivityPaused(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityPaused")
    }

    override fun onActivityStopped(p0: Activity) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityStopped")
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivitySaveInstanceState")
    }

    override fun onActivityDestroyed(p0: Activity) {
        ActivityStackManager.remove(p0)
        Log.e(TAG, "${p0.javaClass.simpleName} --> onActivityDestroyed")
    }

}