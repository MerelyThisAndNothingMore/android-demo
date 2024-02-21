package com.androiddemo.base.app

import com.androiddemo.base.utils.ZLogger
import com.tencent.smtt.utils.LogFileUtils

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
object MainPageSelectOptionManager {

    private const val TAG = "MainPageSelectOptionManager"

    private val options = mutableListOf<IMainPageSelectOption>()

    fun register(option: IMainPageSelectOption) {
        ZLogger.d(TAG, "register: $option")
        options.add(option)
    }

    fun loadAll(): List<IMainPageSelectOption> {
        ZLogger.d(TAG, "loadAll: $options")
        return options
    }
}