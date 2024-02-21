package com.example.libvideoplayer.player

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
interface IVideoView {

    var viewItem: VideoItem?

    fun startPlay()

    fun stopPlay()

}