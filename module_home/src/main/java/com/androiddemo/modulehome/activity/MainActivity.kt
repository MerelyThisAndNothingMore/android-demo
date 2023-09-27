package com.androiddemo.modulehome.activity

import android.graphics.Color
import androidx.activity.viewModels
import com.androiddemo.modulehome.databinding.HomeActivityMainBinding
import com.androiddemo.base.ktx.observeLiveData
import com.androiddemo.base.ktx.setOnSingleClickListener
import com.androiddemo.common.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * 首页
 *
 * @author Qu Yunshuo
 * @since 5/22/21 2:26 PM
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<HomeActivityMainBinding, HomeViewModel>() {

    /**
     * 通过 viewModels() + Hilt 获取 ViewModel 实例
     */
    override val viewModel by viewModels<HomeViewModel>()

    override fun createVB() = HomeActivityMainBinding.inflate(layoutInflater)

    override fun HomeActivityMainBinding.initView() {
        vTvHello.setOnSingleClickListener {
            viewModel.inspectImages(this@MainActivity)
        }
    }

    override fun initObserve() {
        observeLiveData(viewModel.data, ::processData)
    }

    private fun processData(data: String) {
        binding.vTvHello.text = data
        binding.vTvHello.setTextColor(Color.BLUE)
    }

    override fun initRequestData() {
        // 模拟获取数据
        viewModel.getData()
    }
}