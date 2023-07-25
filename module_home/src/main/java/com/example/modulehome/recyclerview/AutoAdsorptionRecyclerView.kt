package com.example.modulehome.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modulehome.recyclerview.inter.IAutoAdsorptionRecyclerView
import kotlin.math.abs

class AutoAdsorptionRecyclerView : IAutoAdsorptionRecyclerView {

    private var recyclerView: RecyclerView? = null


    override fun bind(container: ViewGroup) {
        if (recyclerView == null) {
            recyclerView = RecyclerView(container.context)
            recyclerView?.layoutManager = LinearLayoutManager(
                container.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            recyclerView?.apply {
                this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        super.onScrollStateChanged(recyclerView, newState)

                        if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                            val firstShowPos = layoutManager.findFirstVisibleItemPosition()

                            var targetPosition = firstShowPos

                            val firstShowView = layoutManager.getChildAt(firstShowPos)
                            firstShowView?.let {
                                val startDistance = abs(layoutManager.getDecoratedRight(it))
                                if (startDistance > it.width / 2) {
                                    targetPosition = firstShowPos
                                } else {
                                    targetPosition = firstShowPos + 1
                                }
                            }

                            recyclerView.smoothScrollToPosition(targetPosition)
                        }
                    }
                })
            }
        }
        container.addView(recyclerView)
    }

    override fun recyclerView(): RecyclerView? {
        return recyclerView
    }
}