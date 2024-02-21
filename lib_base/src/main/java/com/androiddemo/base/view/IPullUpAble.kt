package com.androiddemo.base.view

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
interface IPullUpAble {

    fun enablePullUp(enable: Boolean)

    fun isEnablePullUp(): Boolean

    fun isPullingUp(): Boolean

    fun showPullingUp()


    fun setOnPullUpListener(listener: OnPullUpListener)

    interface OnPullUpListener {
        fun onPullUp()
    }
}