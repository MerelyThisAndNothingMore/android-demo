package com.example.libbase.utils

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

/****
 * @author : zhangjing
 * @date : 星期二 9/5/23
 */
object ContextUtil {

    fun getSupportFragmentMangerFromContext(context: Context): FragmentManager? {
        return if (context is FragmentActivity) {
            context.supportFragmentManager
        } else {
            null
        }
    }
}