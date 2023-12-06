package com.androiddemo.base.utils

import android.content.Context
import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/****
 * @author : zhangjing
 * @date : 星期二 11/14/23
 */
object FileUtil {

    fun saveBitmapToFile(context: Context, bitmap: Bitmap, fileName: String): File {
        val outputDir = context.cacheDir // 使用缓存目录
        val outputFile = File(outputDir, fileName)

        try {
            FileOutputStream(outputFile).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out) // PNG格式
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return outputFile
    }

}