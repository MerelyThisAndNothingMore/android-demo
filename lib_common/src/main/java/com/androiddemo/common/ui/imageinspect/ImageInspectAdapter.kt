package com.androiddemo.common.ui.imageinspect

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.androiddemo.base.utils.ImageDownloadListener
import com.androiddemo.base.utils.ImageLoadUtil
import com.androiddemo.common.R
import com.github.piasy.biv.view.BigImageView
import com.shizhefei.view.largeimage.LargeImageView
import com.shizhefei.view.largeimage.factory.FileBitmapDecoderFactory
import java.io.File

/****
 * @author : zhangjing
 * @date : 星期三 9/27/23
 */
class ImageInspectAdapter :
    RecyclerView.Adapter<ImageInspectAdapter.ImageInspectViewHolder>() {

    private val urlList: MutableList<String> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun refresh(urlList: List<String>) {
        this.urlList.clear()
        this.urlList.addAll(urlList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageInspectViewHolder {
        return ImageInspectViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.common_image_inspect_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageInspectViewHolder, position: Int) {
        holder.bind(urlList[position])
    }

    override fun getItemCount(): Int {
        return urlList.size
    }

    class ImageInspectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val normalImage: ImageView = itemView.findViewById(R.id.normal_image)
        private val bigImage: BigImageView = itemView.findViewById(R.id.big_image)
        private val largeImage: LargeImageView = itemView.findViewById(R.id.large_image)
        fun bind(imageUrl: String) {
//            ImageLoadUtil.load(imageUrl, normalImage)
            bigImage.showImage(Uri.parse(imageUrl))
//            largeImage.isEnabled = true
//            ImageLoadUtil.downloadOnly(itemView.context, imageUrl, object : ImageDownloadListener {
//                override fun onLoadFailed(e: Exception?, model: String) {
//
//
//                }
//
//                override fun onResourceReady(resource: File) {
//                    largeImage.setImage(FileBitmapDecoderFactory(resource))
//                }
//            })
        }
    }
}