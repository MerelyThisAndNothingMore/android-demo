package com.androiddemo.modulehome.activity

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.androiddemo.base.ktx.launchIO
import com.androiddemo.base.mvvm.vm.BaseViewModel
import com.androiddemo.modulehome.IntentUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

/**
 * 首页的VM层
 *
 * @property mRepository HomeRepository 仓库层 通过Hilt注入
 *
 * @author Qu Yunshuo
 * @since 5/25/21 5:41 PM
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val mRepository: HomeRepository) : BaseViewModel() {

    companion object {
        private const val TEST_URL1 =
            "https://picuser-tky.weplayapp.com/admin/CF574F78-8136-43FD-BA60-E4FF5E223477.png"
        private const val TEST_URL2 =
            "https://picuser-tky.weplayapp.com/admin/229A2B03-74E3-4CA2-9FB8-10B7D54E08BC.png"
        private const val TEST_URL3 =
            "https://picuser-tky.weplayapp.com/admin/9056B8C5-8D20-4A47-9643-72A86949803C.png"
        private const val TEST_URL4 =
            "https://picuser-tky.weplayapp.com/admin/1F74995D-671D-4210-BE26-DEF5C842D7A3.png"
        private const val TEST_URL5 =
            "https://picuser-tky.weplayapp.com/admin/B3FF7273-ACE7-4EC4-8590-1D093BF675EE.png"

        private val URLS = listOf<String>(
            TEST_URL1,
            TEST_URL2,
            TEST_URL3,
            TEST_URL4,
            TEST_URL5
        )
    }

    val data = MutableLiveData<String>()

    /**
     * 模拟获取数据
     */
    fun getData() {
        launchIO {
            mRepository.getData()
                .catch { Log.d("qqq", "getData: $it") }
                .collect { data.postValue(it) }
        }
    }

    fun inspectImages(context: Context) {
        IntentUtil.gotoImageInspectActivity(context, URLS)
    }
}