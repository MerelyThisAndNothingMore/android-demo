package com.androiddemo.common.ui.imageinspect

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.viewModels
import com.androiddemo.base.app.IMainPageSelectOption
import com.androiddemo.base.ktx.observeLiveData
import com.androiddemo.base.utils.ImageDownloadListener
import com.androiddemo.base.utils.ImageLoadUtil
import com.androiddemo.base.utils.ThreadUtils
import com.androiddemo.common.databinding.CommonImageSingleInspectActivityBinding
import com.androiddemo.common.protocol.IntentConfig
import com.androiddemo.common.ui.frame.BaseActivity
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import java.io.File

/****
 * @author : zhangjing
 * @date : 星期四 10/12/23
 */
class SingleImageInspectActivity :
    BaseActivity<CommonImageSingleInspectActivityBinding, SingleImageInspectViewModel>() {

    companion object {

        fun launch(context: Context, imageUrl: String) {
            val intent = Intent(context, SingleImageInspectActivity::class.java).apply {
                putExtra(IntentConfig.IMAGE_URL, imageUrl)
            }
            context.startActivity(intent)
        }

        val selectOption = object : IMainPageSelectOption {
            override val name: String
                get() = "单张图片查看"

            override fun goto(context: Context) {
                launch(
                    context,
                    "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png"
                )
            }
        }
    }

    override val viewModel by viewModels<SingleImageInspectViewModel>()

    override fun createVB() =
        CommonImageSingleInspectActivityBinding.inflate(layoutInflater)


    override fun initObserve() {
        observeLiveData(viewModel.imageUrl) {
            ImageLoadUtil.downloadOnly(this, it, object : ImageDownloadListener {
                override fun onLoadFailed(e: Exception?, model: String) {

                }

                override fun onResourceReady(resource: File) {
                    ThreadUtils.postOnUIThread {
                        binding.singleBigImage.setImage(ImageSource.uri(Uri.fromFile(resource)))
                        binding.singleBigImage.postDelayed({
                            binding.singleBigImage.setMinimumScaleType(
                                SubsamplingScaleImageView.SCALE_TYPE_CUSTOM
                            )
                        }, 3000L)
                    }
                }
            })
        }
    }

    override fun initRequestData() {
        viewModel.dealIntent(intent)
    }

    override fun CommonImageSingleInspectActivityBinding.initView() {
        singleBigImage.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_START)
    }
}