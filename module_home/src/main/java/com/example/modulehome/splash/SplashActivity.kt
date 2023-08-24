package com.example.modulehome.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import com.example.libcommon.baseui.BaseActivity
import com.example.modulehome.databinding.HomeSplashActivityBinding
import dagger.hilt.android.AndroidEntryPoint

/****
 * @author : zhangjing
 * @date : 星期三 8/23/23
 */
@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<HomeSplashActivityBinding, SplashActivityViewModel>() {


    override val viewModel by viewModels<SplashActivityViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun HomeSplashActivityBinding.initView() {

    }

    override fun initLiveDataObserve() {

    }

    override fun requestData() {

    }


}