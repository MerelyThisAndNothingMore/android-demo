package com.example.modulehome.custom.examples

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/****
 * @author : zhangjing
 * @date : 星期二 9/5/23
 */
class ConwayLifeGame(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    companion object {

    }

    private val cellSize = 20
    private val rows = width / cellSize
    private val cols = height / cellSize
    private var cells: Array<Array<Boolean>> = Array(rows) { Array(cols) { false } }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // Draw cells here
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (cells[i][j]) {
                    canvas?.drawRect(
                        (i * cellSize).toFloat(),
                        (j * cellSize).toFloat(),
                        (i + 1) * cellSize.toFloat(),
                        (j + 1) * cellSize.toFloat(),
                        Paint().apply { color = Color.BLACK }
                    )
                }
            }
        }
    }

    fun step() {
        val newCells = Array(rows) { Array(cols) { false } }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                val neighbors = countNeighbors(i, j)
                newCells[i][j] = when {
                    cells[i][j] && neighbors < 2 -> false
                    cells[i][j] && neighbors > 3 -> false
                    !cells[i][j] && neighbors == 3 -> true
                    else -> cells[i][j]
                }
            }
        }

        cells = newCells
        invalidate()
    }

    private fun countNeighbors(row: Int, col: Int): Int {
        var count = 0
        for (i in -1..1) {
            for (j in -1..1) {
                if (i == 0 && j == 0) continue
                if (isCellAlive(row + i, col + j)) {
                    count++
                }
            }
        }
        return count
    }

    private fun isCellAlive(row: Int, col: Int): Boolean {
        return when {
            row < 0 || col < 0 || row >= rows || col >= cols -> false
            else -> cells[row][col]
        }
    }


}