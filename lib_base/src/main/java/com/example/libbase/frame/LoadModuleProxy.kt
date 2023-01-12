package com.example.libbase.frame

import android.app.Application
import android.content.Context
import com.example.libbase.frame.model.IApplicationLifecycle
import java.util.*

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
class LoadModuleProxy : IApplicationLifecycle {

    private var loaders: ServiceLoader<IApplicationLifecycle> = ServiceLoader.load(IApplicationLifecycle::class.java)

    override fun onAttachBaseContext(context: Context) {
        loaders.forEach {
            it.onAttachBaseContext(context)
        }
    }

    override fun onCreate(application: Application) {
        loaders.forEach {
            it.onCreate(application)
        }
    }

    override fun onTerminate(application: Application) {
        loaders.forEach {
            it.onTerminate(application)
        }
    }

    override fun frontDeskInitTasks(): MutableList<() -> String> {
        return loaders.map {
            it.frontDeskInitTasks()
        }.flatten().toMutableList()
    }

    override fun onInitByBackStage() {
        loaders.forEach { it.onInitByBackStage() }
    }
}