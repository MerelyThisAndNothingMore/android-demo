package com.example.modulehome.custom

import android.content.Context
import android.view.View

/****
 * @author : zhangjing
 * @date : 星期二 9/5/23
 */
interface ICustomInfo {

    fun getCustomViewName(): String

    fun getCustomView(context: Context): View


}