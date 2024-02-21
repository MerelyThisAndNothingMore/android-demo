package com.androiddemo.base.app

import android.content.Context

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
interface IMainPageSelectOption {

    val name: String

    fun goto(context: Context)

}