package com.example.libbase.utils

import android.content.Context
import com.tencent.mmkv.MMKV

/****
 * @author : zhangjin.rolling
 * @date : 星期四 2023/1/12
 */
object SPUtil {

    fun initMMKV(context: Context): String? = MMKV.initialize(context)

}