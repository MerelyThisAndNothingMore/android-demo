package com.androiddemo.base.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

/****
 * @author : zhangjing
 * @date : 星期三 9/27/23
 */
object ImageLoadUtil {

    fun load(url: String, imageView: ImageView) {
        load(url, imageView, ImageLoadConfig())
    }


    fun load(url: String, imageView: ImageView, imageLoadConfig: ImageLoadConfig) {
        load(url, imageView, ImageLoadConfig(), null)
    }

    fun load(
        url: String,
        imageView: ImageView,
        imageLoadConfig: ImageLoadConfig,
        imageLoadListener: ImageLoadListener?
    ) {
        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .into(imageView)
    }
}

class ImageLoadConfig {

}

interface ImageLoadListener {}
