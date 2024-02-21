package com.androiddemo.base.view

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
interface ISwipeLoadMoreAble {

    fun setOnLoadMoreListener(listener: OnLoadMoreListener)

    fun enableLoadMore(enable: Boolean)

    fun isEnableLoadMore(): Boolean

    fun isLoadingMore(): Boolean

    fun showLoadingMore()

    fun dismissLoadingMore()

    fun finishLoadMore()

    interface OnLoadMoreListener {
        fun onLoadMore()
    }

}