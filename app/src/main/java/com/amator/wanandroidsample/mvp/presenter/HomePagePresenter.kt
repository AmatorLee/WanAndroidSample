package com.amator.wanandroidsample.mvp.presenter

import com.amator.wanandroidsample.mvp.base.BasePresenter

/**
 * Created by AmatorLee on 2018/4/26.
 */
interface HomePagePresenter : BasePresenter {

    fun onLoadHomePage()

    fun getBannerDatas()

    fun getHomePageDatas(page: Int)
}