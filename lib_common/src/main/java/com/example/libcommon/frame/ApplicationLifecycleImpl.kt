package com.example.libcommon.frame

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.example.libbase.frame.BaseApplication
import com.example.libbase.frame.model.IApplicationLifecycle
import com.example.libbase.network.NetworkListenHelper
import com.example.libbase.utils.ProcessUtil
import com.example.libbase.utils.SPUtil
import com.google.auto.service.AutoService

/****
 * @author : zhangjin.rolling
 * @date : 星期四 2023/1/12
 */
@AutoService(IApplicationLifecycle::class)
class ApplicationLifecycleImpl : IApplicationLifecycle {

    override fun onAttachBaseContext(context: Context) {
    }

    override fun onCreate(application: Application) {
    }

    override fun onTerminate(application: Application) {
    }

    override fun frontDeskInitTasks(): MutableList<() -> String> {
        val result = mutableListOf<() -> String>()
        if (ProcessUtil.isInMainProcess(BaseApplication.context)) {
            result.add { initMMKV() }
            result.add { initARouter() }
            result.add { initNetworkListen() }
        }
        return result
    }

    override fun onInitByBackStage() {

    }

    private fun initMMKV(): String {
        return "MMKV --> ${SPUtil.initMMKV(BaseApplication.context)}"
    }

    private fun initARouter(): String {
        ARouter.init(BaseApplication.application)
        return "ARouter --> init complete"
    }

    private fun initNetworkListen(): String {
        NetworkListenHelper.startListen()
        return "NetworkListen --> listen start"
    }
}