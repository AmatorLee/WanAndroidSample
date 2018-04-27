package com.amator.wanandroidsample.mvp.view

import com.amator.wanandroidsample.mvp.base.BaseView

/**
 * Created by AmatorLee on 2018/4/27.
 */
interface WelcomeView : BaseView {

    fun getBannerSucceed()

    fun getBannerFailed()
}