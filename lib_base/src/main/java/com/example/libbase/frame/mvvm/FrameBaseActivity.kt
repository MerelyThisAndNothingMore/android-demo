package com.example.libbase.frame.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.example.libbase.model.EventBusRegister
import com.example.libbase.network.NetworkListenAutoSetter
import com.example.libbase.network.NetworkStateChangeListener
import com.example.libbase.network.NetworkType
import com.example.libbase.utils.BindingReflexHelper
import com.example.libbase.utils.EventBusHelper

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
abstract class FrameBaseActivity<VB : ViewBinding, VM : FrameBaseViewModel> : AppCompatActivity(), FrameView<VB>, NetworkStateChangeListener {

    protected val viewBinding: VB by lazy {
        BindingReflexHelper.getViewBinding(javaClass, layoutInflater)
    }

    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        ARouter.getInstance().inject(this)

        if (javaClass.isAnnotationPresent(EventBusRegister::class.java)) {
            EventBusHelper.register(this)
        }

        onInitStatusBar()
        viewBinding.initView()

        lifecycle.addObserver(NetworkListenAutoSetter(this))

        initLiveDataObserve()
        requestData()
    }

    override fun onDestroy() {
        if (javaClass.isAnnotationPresent(EventBusRegister::class.java)) {
            EventBusHelper.unRegister(this)
        }
        super.onDestroy()
    }

    override fun onNetworkTypeChange(networkType: NetworkType) {
    }

    override fun onConnectStateChange(connecting: Boolean) {
    }

    protected open fun onInitStatusBar() {

    }


}