package com.androiddemo.modulehome.homeframe

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androiddemo.base.app.IMainPageSelectOption
import com.androiddemo.modulehome.R

/****
 * @author : zhangjing
 * @date : 星期四 10/12/23
 */
class HomePageContentAdapter : RecyclerView.Adapter<HomePageContentVH>() {

    private val itemList: MutableList<IMainPageSelectOption> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageContentVH {
        return HomePageContentVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_activity_content_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomePageContentVH, position: Int) {
        holder.bind(itemList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshAll(items: List<IMainPageSelectOption>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }
}

class HomePageContentVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val itemNameTV: TextView = itemView.findViewById(R.id.item_name)

    fun bind(itemInfo: IMainPageSelectOption) {
        itemNameTV.text = itemInfo.name
        itemView.setOnClickListener {
            itemInfo.goto(itemView.context)
        }
    }

}