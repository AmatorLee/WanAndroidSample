package com.amator.wanandroidsample.mvp.view

import com.amator.wanandroidsample.bean.ArticleContentBean
import com.amator.wanandroidsample.bean.BannerBean
import com.amator.wanandroidsample.mvp.base.BaseView

/**
 * Created by AmatorLee on 2018/4/26.
 */
interface HomePageView : BaseView {


    fun getBannerSucceed(datas: List<BannerBean>)

    fun getBannerFailed(message: String?)

    fun refreshHomePageSuccceed(datas: List<ArticleContentBean>)

    fun loadMoreHomePageSuccceed(datas: List<ArticleContentBean>)

    fun getHomepageFailed(message: String?)

    fun dismissRefreshAndLoadMore()

}

