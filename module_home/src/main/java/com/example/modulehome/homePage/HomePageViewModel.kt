package com.example.modulehome.homePage

import androidx.lifecycle.MutableLiveData
import com.example.libbase.frame.mvvm.FrameBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/****
 * @author : zhangjin.rolling
 * @date : 星期三 2023/1/11
 */
@HiltViewModel
class HomePageViewModel @Inject constructor() : FrameBaseViewModel() {

    val helloTitle = MutableLiveData<String>()

    fun initData() {
        helloTitle.value = "Hello World!"
    }


}