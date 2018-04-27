package com.amator.wanandroidsample.mvp.presenter.impl

import com.amator.wanandroidsample.http.HttpManager
import com.amator.wanandroidsample.mvp.presenter.HomePagePresenter
import com.amator.wanandroidsample.mvp.view.HomePageView
import com.amator.wanandroidsample.util.applySchedules
import javax.inject.Inject

/**
 * Created by AmatorLee on 2018/4/26.
 */
class HomePagePresenterImpl @Inject
constructor() : BasePresenterImpl<HomePageView>(), HomePagePresenter {
    override fun getBannerDatas() {
        HttpManager.sInstance
                .getBanner()
                .applySchedules()
                .subscribe({
                    when {
                        it.isSucceed() -> mView?.getBannerSucceed(it.data!!)
                        else -> mView?.getBannerFailed(it.errorMsg)
                    }
                }, {
                    mView?.getBannerFailed(it.message)
                })
    }

    override fun getHomePageDatas(page: Int) {
        HttpManager.sInstance
                .getHomePage(page)
                .applySchedules()
                .subscribe({
                    if (it.isSucceed()) {
                        when {
                            page > 0 ->
                                mView?.loadMoreHomePageSuccceed(it.data!!.datas)
                            else -> {
                                mView?.dismissRefreshAndLoadMore()
                                mView?.refreshHomePageSuccceed(it.data!!.datas)
                            }
                        }
                    } else {

                        mView?.getHomepageFailed(it.errorMsg)
                    }
                }, {
                    mView?.getHomepageFailed(it.message)
                })
    }

    override fun onLoadHomePage() {
        getBannerDatas()
        getHomePageDatas(0)
    }

}