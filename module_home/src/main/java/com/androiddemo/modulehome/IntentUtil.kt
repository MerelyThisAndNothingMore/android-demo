package com.androiddemo.modulehome

import android.content.Context
import android.content.Intent
import com.androiddemo.base.ktx.toArrayList
import com.androiddemo.common.protocol.IntentConfig
import com.androiddemo.common.ui.imageinspect.ImageInspectActivity
import com.androiddemo.common.ui.imageinspect.SingleImageInspectActivity

/****
 * @author : zhangjing
 * @date : 星期三 9/27/23
 */
object IntentUtil {

    fun gotoImageInspectActivity(context: Context, urls: List<String>) {
        val intent = Intent(context, ImageInspectActivity::class.java).apply {
            putStringArrayListExtra(IntentConfig.URL_LIST, urls.toArrayList())
        }
        context.startActivity(intent)
    }

    fun gotoSingleImageInspectActivity(context: Context, imageUrl: String) {
        val intent = Intent(context, SingleImageInspectActivity::class.java).apply {
            putExtra(IntentConfig.IMAGE_URL, imageUrl)
        }
        context.startActivity(intent)
    }
}