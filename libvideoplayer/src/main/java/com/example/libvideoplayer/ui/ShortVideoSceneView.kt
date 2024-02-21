package com.example.libvideoplayer.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.androiddemo.base.view.ISwipeRefreshAble
import com.example.libvideoplayer.R

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
class ShortVideoSceneView(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) :
    FrameLayout(context, attributeSet, defStyleAttr), ISwipeRefreshAble {

    private var onRefreshListener: ISwipeRefreshAble.OnRefreshListener? = null


    init {
        initView()
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.short_video_scene, this, true)

        findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout).setOnRefreshListener {
            onRefreshListener?.onRefresh()
        }
    }

    override fun setOnRefreshListener(listener: ISwipeRefreshAble.OnRefreshListener) {
        onRefreshListener = listener
    }


}