package com.example.modulehome.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.libcommon.baseui.BaseActivity
import com.example.modulehome.R
import com.example.modulehome.databinding.HomeSplashActivityBinding
import com.example.modulehome.homePage.HomePageActivity
import dagger.hilt.android.AndroidEntryPoint

/****
 * @author : zhangjing
 * @date : 星期三 8/23/23
 */
@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<HomeSplashActivityBinding, SplashActivityViewModel>() {

    companion object {
        private const val SPLASH_PAGE_LAST_TIME = 2000L

    }


    override val viewModel by viewModels<SplashActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AndroidDemo)
        super.onCreate(savedInstanceState)

    }

    override fun HomeSplashActivityBinding.initView() {
        splashRootView.postDelayed({
            viewModel.launchHomeActivity(this@SplashActivity)
            finish()
        }, SPLASH_PAGE_LAST_TIME)
    }

    override fun initLiveDataObserve() {

    }

    override fun requestData() {

    }


}