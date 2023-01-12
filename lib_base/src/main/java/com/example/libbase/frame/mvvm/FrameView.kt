package com.example.libbase.frame.mvvm

import androidx.viewbinding.ViewBinding

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
interface FrameView<VB : ViewBinding> {
    // 在数据到达前初始化View参数
    fun VB.initView()

    fun initLiveDataObserve()

    fun requestData()
}