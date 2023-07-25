package com.example.modulehome.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modulehome.R
import com.example.modulehome.recyclerview.CommonViewHolder.Companion.TAG

class CommonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        const val TAG = "CommonViewHolder"
    }

    private val titleTV: TextView = itemView.findViewById(R.id.title)
    private val authorTV: TextView = itemView.findViewById(R.id.author)
    private val contentRecyclerView: RecyclerView =
        itemView.findViewById(R.id.content_recycler_view)


    fun bindData(data: CommonHolderData) {
        titleTV.text = data.title
        authorTV.text = data.author
        val subAdapter = SubAdapter()
        subAdapter.setData(data.content)
        Log.d(TAG, "${data.content}")
        contentRecyclerView.adapter = subAdapter
        contentRecyclerView.layoutManager =
            LinearLayoutManager(contentRecyclerView.context, LinearLayoutManager.VERTICAL, false)

    }

}

data class CommonHolderData(
    val title: String,
    val author: String,
    val content: List<String>
)

class SubAdapter : RecyclerView.Adapter<SubAdapter.SubViewHolder>() {

    private val dataList: MutableList<String> = mutableListOf()

    fun setData(data: List<String>) {
        dataList.clear()
        dataList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_sub_view_holder, parent, false)

        return SubViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "size : ${dataList.size}")
        return dataList.size
    }

    override fun onBindViewHolder(holder: SubViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }


    class SubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val poemTV: TextView = itemView.findViewById(R.id.poem_text)

        fun bindData(data: String) {
            poemTV.text = data
        }
    }
}


