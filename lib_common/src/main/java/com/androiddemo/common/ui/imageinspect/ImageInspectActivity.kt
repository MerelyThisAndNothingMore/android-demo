package com.androiddemo.common.ui.imageinspect

import androidx.activity.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androiddemo.common.databinding.CommonImageInspectActivityBinding
import com.androiddemo.common.protocol.IntentConfig
import com.androiddemo.common.ui.BaseActivity

/****
 * @author : zhangjing
 * @date : 星期三 9/27/23
 */
class ImageInspectActivity :
    BaseActivity<CommonImageInspectActivityBinding, ImageInspectViewModel>() {

    override val viewModel by viewModels<ImageInspectViewModel>()
    override fun createVB() = CommonImageInspectActivityBinding.inflate(layoutInflater)

    private val pagerAdapter: ImageInspectAdapter by lazy { ImageInspectAdapter() }

    override fun initObserve() {

    }

    override fun initRequestData() {
        intent.getStringArrayListExtra(IntentConfig.URL_LIST)?.let {
            pagerAdapter.refresh(it)
        }
    }

    override fun CommonImageInspectActivityBinding.initView() {
        imageInspectViewPager.adapter = pagerAdapter
    }
}