package com.androiddemo.base.view

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
interface ISwipeRefreshAble {

    fun setOnRefreshListener(listener: OnRefreshListener)

    interface OnRefreshListener {
        fun onRefresh()
    }
}