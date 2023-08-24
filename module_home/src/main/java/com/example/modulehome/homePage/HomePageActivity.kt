package com.example.modulehome.homePage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.libbase.ktx.observeLiveData
import com.example.libcommon.baseui.BaseActivity
import com.example.modulehome.custom.CustomActivity
import com.example.modulehome.databinding.HomePageActivityBinding
import com.example.modulehome.recyclerview.AutoAdsorptionRecyclerView
import com.example.modulehome.recyclerview.CommonAdapter
import com.example.modulehome.recyclerview.CommonHolderData
import com.example.modulehome.recyclerview.CommonViewHolder
import com.example.modulehome.recyclerview.inter.IAutoAdsorptionRecyclerView
import dagger.hilt.android.AndroidEntryPoint

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
class HomePageActivity : BaseActivity<HomePageActivityBinding, HomePageViewModel>() {

    companion object {


        fun launchHomePage(activity: AppCompatActivity) {
            val intent = Intent(activity, HomePageActivity::class.java)

        }
    }

    private val adapter by lazy {
        CommonAdapter<CommonHolderData, CommonViewHolder>(
            {
                CommonViewHolder(it)
            }, {
                this.bindData(it)
            }
        )
    }

    override val viewModel by viewModels<HomePageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun HomePageActivityBinding.initView() {

        val recyclerView: IAutoAdsorptionRecyclerView = AutoAdsorptionRecyclerView()
        recyclerView.bind(viewBinding.recyclerViewContainer)
        recyclerView.recyclerView()?.adapter = adapter

        val button: Button = viewBinding.customButton
        button.setOnClickListener {
            val intent = Intent(this@HomePageActivity, CustomActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initLiveDataObserve() {
//        observeLiveData(viewModel.helloTitle) {
//            viewBinding.helloTitle.text = it
//        }

        observeLiveData(viewModel.recyclerViewData) {
            adapter.setData(it)
        }
    }

    override fun requestData() {
        viewModel.initData()
    }
}