package com.example.libvideoplayer

import android.app.Application
import android.content.Context
import com.androiddemo.base.app.ApplicationLifecycle
import com.google.auto.service.AutoService

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */

@AutoService(ApplicationLifecycle::class)
class LibPlayerApplication : ApplicationLifecycle {
    override fun onAttachBaseContext(context: Context) {
    }

    override fun onCreate(application: Application) {
    }

    override fun onTerminate(application: Application) {
    }

    override fun initByFrontDesk(): MutableList<() -> String> {
        return mutableListOf()
    }

    override fun initByBackstage() {
    }
}