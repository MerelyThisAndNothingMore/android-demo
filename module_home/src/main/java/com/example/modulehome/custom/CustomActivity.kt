package com.example.modulehome.custom

import androidx.activity.viewModels
import com.example.libcommon.baseui.BaseActivity
import com.example.modulehome.databinding.HomeCustomActivityBinding

class CustomActivity : BaseActivity<HomeCustomActivityBinding, CustomPageViewModel>() {

    override val viewModel by viewModels<CustomPageViewModel>()


    override fun initLiveDataObserve() {

    }

    override fun requestData() {

    }

    override fun HomeCustomActivityBinding.initView() {
        viewBinding.taiChi.setOnClickListener {
            if (viewBinding.taiChi.isPlaying) {
                viewBinding.taiChi.animPause()
            } else {
                viewBinding.taiChi.animPlay()
            }
        }
    }
}