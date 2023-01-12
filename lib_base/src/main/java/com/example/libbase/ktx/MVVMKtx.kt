package com.example.libbase.ktx

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/****
 * @author : zhangjin.rolling
 * @date : 星期三 2023/1/11
 */
inline fun <T> LifecycleOwner.observeLiveData(
    liveData: LiveData<T>,
    crossinline action: (T) -> Unit
) {
    liveData.observe(this) {
        it?.let(action)
    }
}