package com.example.libvideoplayer.player

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
interface IPlayerController {

    companion object {
        const val TAG = "IPlayerController"

        fun newInstance(): IPlayerController {
            return PlayerController()
        }
    }


}