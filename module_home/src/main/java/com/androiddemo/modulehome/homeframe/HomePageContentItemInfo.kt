package com.androiddemo.modulehome.homeframe

import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import com.androiddemo.modulehome.IntentUtil

/****
 * @author : zhangjing
 * @date : 星期四 10/12/23
 */
enum class HomePageContentItemInfo {
    SINGLE_BIG_IMAGE {


        override fun goto(context: Context) {
            IntentUtil.gotoSingleImageInspectActivity(context, TEST_URL2)
        }
    },
    TEST_BOARD {
        override fun goto(context: Context) {
            val linearGradient = LinearGradient(
                0f,
                0f,
                0f,
                0f,
                Color.BLUE,
                Color.BLACK,
                Shader.TileMode.CLAMP
            )
            linearGradient.toString()
        }
    },
    BIG_IMAGES {


        override fun goto(context: Context) {
            IntentUtil.gotoImageInspectActivity(context, URLS)
        }
    };

    abstract fun goto(context: Context): Unit


    companion object {
        const val TEST_URL1 =
            "https://picuser-tky.weplayapp.com/admin/CF574F78-8136-43FD-BA60-E4FF5E223477.png"
        const val TEST_URL2 =
            "https://picuser-tky.weplayapp.com/admin/229A2B03-74E3-4CA2-9FB8-10B7D54E08BC.png"
        const val TEST_URL3 =
            "https://picuser-tky.weplayapp.com/admin/9056B8C5-8D20-4A47-9643-72A86949803C.png"
        const val TEST_URL4 =
            "https://picuser-tky.weplayapp.com/admin/1F74995D-671D-4210-BE26-DEF5C842D7A3.png"
        const val TEST_URL5 =
            "https://picuser-tky.weplayapp.com/admin/B3FF7273-ACE7-4EC4-8590-1D093BF675EE.png"
        const val TEST_URL6 =
            "https://s1.aigei.com/src/img/gif/a2/a23e1935964d4465bcfe1f17625fc8a6.gif?imageMogr2/auto-orient/thumbnail/!282x225r/gravity/Center/crop/282x225/quality/85/&e=1735488000&token=P7S2Xpzfz11vAkASLTkfHN7Fw-oOZBecqeJaxypL:w_9_H8fmwKSmSXZxR-lNZNYuQRQ="


        private val URLS = listOf<String>(
            TEST_URL1,
            TEST_URL2,
            TEST_URL6
        )
    }
}


