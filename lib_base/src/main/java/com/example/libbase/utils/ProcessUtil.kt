package com.example.libbase.utils

import android.app.ActivityManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Process
import kotlin.jvm.Throws

/****
 * @author : zhangjin.rolling
 * @date : 星期四 2023/1/12
 */
object ProcessUtil {

    fun isInMainProcess(context: Context): Boolean {
        return isPidBelongToProcess(context, Process.myPid(), mainProcessName(context))
    }

    private fun isPidBelongToProcess(context: Context, pid: Int, processName: String): Boolean {
        runningAppProcesses(context).forEach {
            if (it.pid == pid) {
                return (it.processName == processName)
            }
        }
        return false
    }

    @Throws(PackageManager.NameNotFoundException::class)
    private fun mainProcessName(context: Context): String {
        return context.packageManager.getApplicationInfo(context.packageName, 0).processName
    }

    private fun runningAppProcesses(context: Context): List<ActivityManager.RunningAppProcessInfo> {
        return (context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).runningAppProcesses
    }


}