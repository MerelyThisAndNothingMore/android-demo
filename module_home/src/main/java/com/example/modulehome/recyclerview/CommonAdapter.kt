package com.example.modulehome.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modulehome.R

class CommonAdapter<T, H : RecyclerView.ViewHolder>(
    private val createHolder: (View) -> H,
    val bindHolder: H.(T) -> Unit
) : RecyclerView.Adapter<H>() {

    private val dataList: MutableList<T> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): H {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_common_view_holder, parent, false)
        
        return createHolder.invoke(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: H, position: Int) {
        val data = dataList[position]
        holder.bindHolder(data)
    }

    fun setData(data: List<T>) {
        dataList.clear()
        dataList.addAll(data)
    }
}
