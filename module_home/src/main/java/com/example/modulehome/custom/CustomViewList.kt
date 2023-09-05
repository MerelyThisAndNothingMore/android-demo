package com.example.modulehome.custom

import com.example.modulehome.custom.custominfo.CartesianViewInfo
import com.example.modulehome.custom.custominfo.TaiChiViewInfo

/****
 * @author : zhangjing
 * @date : 星期二 9/5/23
 */
object CustomViewList {

    val customList: List<ICustomInfo> = listOf(
        TaiChiViewInfo(),
        CartesianViewInfo()
    )


}