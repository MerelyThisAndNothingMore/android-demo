package com.androiddemo.common.ui.imageinspect

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.androiddemo.base.mvvm.vm.BaseViewModel
import com.androiddemo.common.protocol.IntentConfig

/****
 * @author : zhangjing
 * @date : 星期四 10/12/23
 */
class SingleImageInspectViewModel : BaseViewModel() {

    val imageUrl: MutableLiveData<String> = MutableLiveData()

    override fun dealIntent(intent: Intent) {
        super.dealIntent(intent)
        intent.getStringExtra(IntentConfig.IMAGE_URL)?.let {
            imageUrl.value = it
        }
    }

}