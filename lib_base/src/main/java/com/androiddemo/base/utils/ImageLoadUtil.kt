package com.androiddemo.base.utils

import android.content.Context
import android.widget.ImageView
import com.androiddemo.base.BaseApplication
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import java.io.File

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

    fun downloadOnly(url: String, downloadListener: ImageDownloadListener) {
        downloadOnly(BaseApplication.context, url, downloadListener)
    }

    fun downloadOnly(context: Context, url: String, downloadListener: ImageDownloadListener) {
        Glide.with(context).download(url).addListener(
            object : RequestListener<File> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<File>,
                    isFirstResource: Boolean
                ): Boolean {
                    downloadListener.onLoadFailed(e, model as String)
                    return false
                }

                override fun onResourceReady(
                    resource: File,
                    model: Any,
                    target: Target<File>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    downloadListener.onResourceReady(resource)
                    return false
                }
            }
        ).submit()
    }
}

class ImageLoadConfig {

}

interface ImageLoadListener {}

interface ImageDownloadListener {
    fun onLoadFailed(e: Exception?, model: String)

    fun onResourceReady(resource: File)
}
