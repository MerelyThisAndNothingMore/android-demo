package com.example.libvideoplayer.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.libvideoplayer.player.IPlayerController

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
class ShortVideoFeedPageView(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
    FrameLayout(context, attrs, defStyleAttr) {

    private val videoViewPager: ViewPager2 by lazy {
        ViewPager2(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            orientation = ViewPager2.ORIENTATION_VERTICAL
        }
    }

    private val videoAdapter: ShortVideoAdapter by lazy {
        ShortVideoAdapter()
    }

    private val playerController: IPlayerController by lazy {
        IPlayerController.newInstance()
    }




    init {
        initView()
    }

    private fun initView() {

    }

}