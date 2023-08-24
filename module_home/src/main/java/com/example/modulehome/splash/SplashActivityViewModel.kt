package com.example.modulehome.splash

import com.example.libbase.frame.mvvm.FrameBaseViewModel
import com.example.modulehome.homePage.HomePageActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/****
 * @author : zhangjing
 * @date : 星期三 8/23/23
 */
@HiltViewModel
class SplashActivityViewModel@Inject constructor() : FrameBaseViewModel() {




    fun launchHomeActivity() {

        HomePageActivity.launchHomePage()
    }
}