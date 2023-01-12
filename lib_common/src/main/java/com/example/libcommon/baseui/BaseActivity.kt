package com.example.libcommon.baseui

import androidx.viewbinding.ViewBinding
import com.example.libbase.frame.mvvm.FrameBaseActivity
import com.example.libbase.frame.mvvm.FrameBaseViewModel
import com.example.libbase.utils.StatusBarUtil

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
abstract class BaseActivity<VB : ViewBinding, VM : FrameBaseViewModel> : FrameBaseActivity<VB, VM>() {

    override fun onInitStatusBar() {
        StatusBarUtil.transparentStatusBar(this)
        StatusBarUtil.setStatusBarLightMode(this, true)
    }
}