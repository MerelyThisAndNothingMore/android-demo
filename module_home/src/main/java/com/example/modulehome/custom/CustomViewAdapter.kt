package com.example.modulehome.custom

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.libbase.utils.ContextUtil
import com.example.modulehome.R
import kotlin.random.Random

/****
 * @author : zhangjing
 * @date : 星期二 9/5/23
 */
class CustomViewAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    private val customList: MutableList<ICustomInfo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_custom_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return customList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val customInfo = customList[position]
        holder.bind(customInfo)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun bindData(list: List<ICustomInfo>) {
        customList.clear()
        customList.addAll(list)
        notifyDataSetChanged()
    }
}


class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        private const val COLOR_VALUE_BOUND = 256
    }

    private val customTitle: TextView by lazy {
        itemView.findViewById(R.id.custom_view_title)
    }

    fun bind(customInfo: ICustomInfo) {
        customTitle.text = customInfo.getCustomViewName()
        itemView.setBackgroundColor(getRandomColor())

        itemView.setOnClickListener {
            ContextUtil.getSupportFragmentMangerFromContext(itemView.context)?.let {
                CustomViewDialog(customInfo.getCustomView(itemView.context))
                    .show(it, customInfo.getCustomViewName())
            }
        }
    }

    private fun getRandomColor(): Int {
        return Color.argb(
            Random.nextInt(COLOR_VALUE_BOUND),             // Alpha value (255 means fully opaque)
            Random.nextInt(COLOR_VALUE_BOUND), // Red value
            Random.nextInt(COLOR_VALUE_BOUND), // Green value
            Random.nextInt(COLOR_VALUE_BOUND)  // Blue value
        )
    }
}