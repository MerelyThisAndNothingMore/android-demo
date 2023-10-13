package com.androiddemo.modulehome.activity

import android.graphics.Color
import android.net.Uri
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddemo.modulehome.databinding.HomeActivityMainBinding
import com.androiddemo.base.ktx.observeLiveData
import com.androiddemo.base.ktx.setOnSingleClickListener
import com.androiddemo.base.utils.ImageDownloadListener
import com.androiddemo.base.utils.ImageLoadUtil
import com.androiddemo.base.utils.ThreadUtils
import com.androiddemo.common.ui.BaseActivity
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

/**
 * 首页
 *
 * @author Qu Yunshuo
 * @since 5/22/21 2:26 PM
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<HomeActivityMainBinding, HomeViewModel>() {

    private val adapter by lazy {
        HomePageContentAdapter()
    }

    /**
     * 通过 viewModels() + Hilt 获取 ViewModel 实例
     */
    override val viewModel by viewModels<HomeViewModel>()

    override fun createVB() = HomeActivityMainBinding.inflate(layoutInflater)

    override fun HomeActivityMainBinding.initView() {
        contentRecyclerView.adapter = adapter
        contentRecyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
    }

    override fun initObserve() {
        observeLiveData(viewModel.itemList) {
            adapter.refreshAll(it)
        }
    }


    override fun initRequestData() {
        // 模拟获取数据
        viewModel.getData()

    }
}