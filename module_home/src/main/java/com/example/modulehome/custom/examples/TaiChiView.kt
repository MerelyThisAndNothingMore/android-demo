package com.example.modulehome.custom.examples

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator

class TaiChiView(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    companion object {

        const val TAG = "TaiChiView"

        private const val ARC_YIN_START_ANGLE = 0f
        private const val ARC_YANG_START_ANGLE = 180f
        private const val HALF_CIRCLE = 180f

        private const val DEFAULT_ONE_CIRCLE_TIME = 500L
    }

    private val paint: Paint = Paint()
    private val rectF = RectF(0f, 0f, ARC_YIN_START_ANGLE, HALF_CIRCLE)

    private val yinColor: Int = Color.BLACK
    private val yangColor: Int = Color.WHITE

    private var radius: Int = 200

    private var animator: ObjectAnimator? = null
    private var oneCircleTime: Long = DEFAULT_ONE_CIRCLE_TIME

    var isPlaying: Boolean = false
        private set

    init {
        init()
    }

    private fun init() {
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        radius = minOf(width, height) / 2

        val midWidth = width / 2
        val midHeight = height / 2

        Log.d(TAG, "$width, $height")

        val drawLeft = (midWidth - radius).toFloat()
        val drawRight = (midWidth + radius).toFloat()
        val drawTop = (midHeight - radius).toFloat()
        val drawBottom = (midHeight + radius).toFloat()

        // outer yin
        paint.color = yinColor
        rectF.set(drawLeft, drawTop, drawRight, drawBottom)
        canvas?.drawArc(rectF, ARC_YIN_START_ANGLE, HALF_CIRCLE, true, paint)

        // outer yang
        paint.color = yangColor
        rectF.set(drawLeft, drawTop, drawRight, drawBottom)
        canvas?.drawArc(rectF, ARC_YANG_START_ANGLE, HALF_CIRCLE, true, paint)

        // inner yin
        paint.color = yinColor
        rectF.set(
            drawLeft, (midHeight - radius / 2).toFloat(), midWidth.toFloat(),
            (midHeight + radius / 2).toFloat()
        )
        canvas?.drawArc(rectF, ARC_YANG_START_ANGLE, HALF_CIRCLE, true, paint)

        // inner yang
        paint.color = yangColor
        rectF.set(
            midWidth.toFloat(), (midHeight - radius / 2).toFloat(), drawRight,
            (midHeight + radius / 2).toFloat()
        )
        canvas?.drawArc(rectF, ARC_YIN_START_ANGLE, HALF_CIRCLE, true, paint)

        // yin point
        paint.color = yinColor
        canvas?.drawCircle(
            (midWidth + radius / 2).toFloat(), midHeight.toFloat(),
            (radius / 8).toFloat(), paint
        )

        // yang point
        paint.color = yangColor
        canvas?.drawCircle(
            (midWidth - radius / 2).toFloat(), midHeight.toFloat(),
            (radius / 8).toFloat(), paint
        )
    }

    fun animPlay() {
        if (animator == null) {
            animator = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f)

            animator?.duration = oneCircleTime
            animator?.interpolator = LinearInterpolator()
            animator?.repeatCount = ObjectAnimator.INFINITE
            animator?.repeatMode = ObjectAnimator.RESTART
            animator?.start()
        } else {
            animator?.resume()
        }
        isPlaying = true
    }

    fun animPause() {
        animator?.pause()
        isPlaying = false
    }

    fun animStop() {
        animator?.end()
    }

}