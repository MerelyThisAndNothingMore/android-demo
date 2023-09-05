package com.example.modulehome.custom.examples

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

/**
 * 心形线
 */
class CartesianView(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    companion object {
        private const val STROKE_WIDTH = 2f
    }

    private val paint: Paint = Paint()
    private val path: Path = Path()

    init {
        init()
    }

    private fun init() {
        paint.color = Color.BLACK
        paint.strokeWidth = STROKE_WIDTH
        paint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val centerX = width / 2
        val centerY = height / 2

        val radius = minOf(centerX, centerY) / 2

        canvas?.drawLine(centerX.toFloat(), 0F, centerX.toFloat(), height.toFloat(), paint)
        canvas?.drawLine(0f, centerY.toFloat(), width.toFloat(), centerY.toFloat(), paint)

        path.reset()

        for (angle in 0..360) {
            val radians = Math.toRadians(angle.toDouble())
            val r = 1 + cos(radians)

            val x = (centerX + r * radius * cos(radians))
            val y = (centerY - r * radius * sin(radians))

            if (angle == 0) {
                path.moveTo(x.toFloat(), y.toFloat())
            } else {
                path.lineTo(x.toFloat(), y.toFloat())
            }
        }

        canvas?.drawPath(path, paint)
    }
}