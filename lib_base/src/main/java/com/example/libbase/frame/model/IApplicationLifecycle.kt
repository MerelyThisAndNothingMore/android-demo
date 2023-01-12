package com.example.libbase.frame.model

import android.app.Application
import android.content.Context

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
interface IApplicationLifecycle {

    companion object {
        const val INIT_TAG = "ApplicationInit"
    }

    fun onAttachBaseContext(context: Context)

    fun onCreate(application: Application)

    fun onTerminate(application: Application)

    /*
    * 需要前台初始化的组件
    * Return: 初始化方法，返回组件名
    * */
    fun frontDeskInitTasks(): MutableList<() -> String>

    /*
    * 后台调用，在这里初始化低优组件
    * */
    fun onInitByBackStage()
}