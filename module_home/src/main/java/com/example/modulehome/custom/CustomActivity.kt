package com.example.modulehome.custom

import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.libcommon.baseui.BaseActivity
import com.example.modulehome.databinding.HomeCustomActivityBinding

class CustomActivity : BaseActivity<HomeCustomActivityBinding, CustomPageViewModel>() {

    private val customViewAdapter by lazy {
        CustomViewAdapter()
    }
    private val customViewLayoutManager by lazy {
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override val viewModel by viewModels<CustomPageViewModel>()


    override fun initLiveDataObserve() {

    }

    override fun requestData() {
        customViewAdapter.bindData(CustomViewList.customList)
    }

    override fun HomeCustomActivityBinding.initView() {

        viewBinding.customViewList.adapter = customViewAdapter
        viewBinding.customViewList.layoutManager = customViewLayoutManager
    }


}