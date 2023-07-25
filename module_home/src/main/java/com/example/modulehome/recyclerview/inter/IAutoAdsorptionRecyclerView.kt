package com.example.modulehome.recyclerview.inter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

interface IAutoAdsorptionRecyclerView {

    fun bind(container: ViewGroup)

    fun recyclerView(): RecyclerView?


}