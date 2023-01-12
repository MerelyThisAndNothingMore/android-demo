package com.example.modulehome.homePage

import androidx.activity.viewModels
import com.example.libbase.ktx.observeLiveData
import com.example.libcommon.baseui.BaseActivity
import com.example.modulehome.databinding.HomePageActivityBinding
import dagger.hilt.android.AndroidEntryPoint

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
@AndroidEntryPoint
class HomePageActivity: BaseActivity<HomePageActivityBinding, HomePageViewModel>() {

    override val viewModel by viewModels<HomePageViewModel>()

    override fun HomePageActivityBinding.initView() {

    }

    override fun initLiveDataObserve() {
        observeLiveData(viewModel.helloTitle) {
            viewBinding.helloTitle.text = it
        }
    }

    override fun requestData() {
        viewModel.initData()
    }
}