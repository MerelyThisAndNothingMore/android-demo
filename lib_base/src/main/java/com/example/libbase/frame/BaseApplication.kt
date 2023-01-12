package com.example.libbase.frame

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.libbase.frame.model.ActivityLifecycleCallBackImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

/****
 * @author : zhangjin.rolling
 * @date : 星期一 2023/1/9
 */
open class BaseApplication: MultiDexApplication() {

    companion object {
        private const val TAG = "BaseApplication"

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var application: BaseApplication
    }

    private val coroutineScope by lazy (mode = LazyThreadSafetyMode.NONE) { MainScope() }

    private val loadModuleProxy by lazy (mode = LazyThreadSafetyMode.NONE) { LoadModuleProxy() }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        context = base
        application = this
        loadModuleProxy.onAttachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(ActivityLifecycleCallBackImpl())

        loadModuleProxy.onCreate(this)

        initDependencies()
    }

    override fun onTerminate() {
        super.onTerminate()
        loadModuleProxy.onTerminate(application)
        coroutineScope.cancel()
    }

    private fun initDependencies() {

        coroutineScope.launch(Dispatchers.Default) {
            loadModuleProxy.onInitByBackStage()
        }

        val timeConsumingWhole = measureTimeMillis {
            loadModuleProxy.frontDeskInitTasks().forEach {
                var dependenceInfo: String = ""
                val timeConsuming = measureTimeMillis { dependenceInfo = it.invoke() }
                Log.d(TAG, "dependence $dependenceInfo initialed, cost $timeConsuming ms.")
            }
        }
        Log.d(TAG, "all front desk tasks finished, cost $timeConsumingWhole ms.")
    }
}