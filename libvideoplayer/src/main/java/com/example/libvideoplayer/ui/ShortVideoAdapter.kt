package com.example.libvideoplayer.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androiddemo.base.ktx.doIfNotEmpty
import com.androiddemo.base.ktx.safeGet
import com.example.libvideoplayer.R
import com.example.libvideoplayer.player.IVideoView
import com.example.libvideoplayer.player.VideoItem

/**
 * @author : zhangjing
 * @date : 星期三 2/21/24
 */
class ShortVideoAdapter : RecyclerView.Adapter<ShortVideoAdapter.ViewHolder>() {

    private val videoList = mutableListOf<VideoItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun update(videoList: List<VideoItem>) {
        this.videoList.clear()
        this.videoList.addAll(videoList)
        notifyDataSetChanged()
    }

    fun prepend(videoList: List<VideoItem>) {
        videoList.doIfNotEmpty {
            this.videoList.addAll(0, it)
            notifyItemRangeInserted(0, it.size)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun append(videoList: List<VideoItem>) {
        videoList.doIfNotEmpty {
            val startPosition = this.videoList.size
            this.videoList.addAll(it)
            if (startPosition > 0) {
                notifyItemRangeInserted(startPosition, it.size)
            } else {
                notifyDataSetChanged()
            }
        }
    }

    fun delete(position: Int) {
        if (position in 0 until videoList.size) {
            videoList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun replace(position: Int, videoItem: VideoItem) {
        if (position in 0 until videoList.size) {
            videoList[position] = videoItem
            notifyItemChanged(position)
        }
    }

    fun getItem(position: Int): VideoItem? {
        return if (position in 0 until videoList.size) {
            videoList[position]
        } else {
            null
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.videoView.stopPlay()
    }

    override fun onViewRecycled(holder: ViewHolder) {
        holder.videoView.stopPlay()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        videoList.safeGet(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.short_video_item, parent, false)
                view.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                return ViewHolder(view)
            }
        }

        val videoView: IVideoView = itemView as IVideoView

        fun bind(videoItem: VideoItem) {
            videoView.viewItem = videoItem
        }
    }
}