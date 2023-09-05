package com.example.modulehome.custom.custominfo

import android.content.Context
import android.view.View
import com.example.modulehome.custom.ICustomInfo
import com.example.modulehome.custom.examples.TaiChiView

/****
 * @author : zhangjing
 * @date : 星期二 9/5/23
 */
class TaiChiViewInfo: ICustomInfo {
    override fun getCustomViewName(): String {
        return "太极图"
    }

    override fun getCustomView(context: Context): View {
        return TaiChiView(context)
    }
}