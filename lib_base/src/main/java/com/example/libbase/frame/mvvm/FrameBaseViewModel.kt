package com.example.libbase.frame.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
open class FrameBaseViewModel: ViewModel() {

    private val viewState = MutableLiveData<ViewState>()


}