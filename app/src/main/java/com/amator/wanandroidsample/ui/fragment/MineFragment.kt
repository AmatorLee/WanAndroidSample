package com.amator.wanandroidsample.ui.fragment

import android.os.Bundle
import android.view.View
import com.amator.wanandroidsample.R
import com.amator.wanandroidsample.base.BaseFragment
import com.amator.wanandroidsample.di.component.ApplicationComponent
import com.amator.wanandroidsample.di.component.DaggerFragmentComponent
import com.amator.wanandroidsample.di.module.FragmentModule
import com.amator.wanandroidsample.mvp.presenter.impl.MinePresenterImpl
import com.amator.wanandroidsample.mvp.view.MineView

/**
 * Created by AmatorLee on 2018/4/26.
 */
class MineFragment : BaseFragment<MinePresenterImpl>(), MineView {
    override fun initData() {

    }

    override fun setListener() {
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
    }

    override fun injector(applicationComponent: ApplicationComponent) {
        DaggerFragmentComponent.builder()
                .applicationComponent(applicationComponent)
                .fragmentModule(FragmentModule(this))
                .build()
                .inject(this)
    }

    override fun getLayoutId(): Int = R.layout.fragment_mine

}