package com.example.modulehome.splash

import androidx.appcompat.app.AppCompatActivity
import com.example.libbase.frame.mvvm.FrameBaseViewModel
import com.example.modulehome.homePage.HomePageActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/****
 * @author : zhangjing
 * @date : 星期三 8/23/23
 */
@HiltViewModel
class SplashActivityViewModel @Inject constructor() : FrameBaseViewModel() {

    companion object {
        private const val IMAGE_URL =
            "https://tuapi.eees.cc/api.php?category=meinv&type=302&px=m"
    }

    val splashBG: String
        get() = IMAGE_URL


    fun launchHomeActivity(activity: AppCompatActivity) {
        HomePageActivity.launchHomePage(activity)
    }
}