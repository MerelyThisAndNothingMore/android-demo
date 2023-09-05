package com.example.modulehome.custom.custominfo

import android.content.Context
import android.view.View
import com.example.modulehome.custom.ICustomInfo
import com.example.modulehome.custom.examples.CartesianView

/****
 * @author : zhangjing
 * @date : 星期二 9/5/23
 */
class CartesianViewInfo: ICustomInfo {

    override fun getCustomViewName(): String {
        return "坐标系-心形线"
    }

    override fun getCustomView(context: Context): View {
        return CartesianView(context)
    }
}