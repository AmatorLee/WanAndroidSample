package com.amator.wanandroidsample.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.amator.wanandroidsample.R
import com.amator.wanandroidsample.adapter.HomePageAdapter
import com.amator.wanandroidsample.base.BaseFragment
import com.amator.wanandroidsample.bean.ArticleContentBean
import com.amator.wanandroidsample.bean.BannerBean
import com.amator.wanandroidsample.di.component.ApplicationComponent
import com.amator.wanandroidsample.di.component.DaggerFragmentComponent
import com.amator.wanandroidsample.di.module.FragmentModule
import com.amator.wanandroidsample.mvp.presenter.impl.HomePagePresenterImpl
import com.amator.wanandroidsample.mvp.view.HomePageView
import com.amator.wanandroidsample.util.GlideImageLoader
import com.amator.wanandroidsample.util.StatusViewManager
import com.amator.wanandroidsample.util.createView
import kotlinx.android.synthetic.main.fragment_homepage.*
import kotlinx.android.synthetic.main.layout_homepage_header.view.*

/**
 * Created by AmatorLee on 2018/4/26.
 */
class HomePageFragment : BaseFragment<HomePagePresenterImpl>(), HomePageView {
    override fun injector(applicationComponent: ApplicationComponent) {
        DaggerFragmentComponent.builder()
                .applicationComponent(applicationComponent)
                .fragmentModule(FragmentModule(this))
                .build()
                .inject(this)
    }

    override fun initData() {
        mPresenter?.onLoadHomePage()
    }

    override fun dismissRefreshAndLoadMore() {
        recycler_homepage.dismissSwipeRefresh()
    }

    override fun getBannerSucceed(datas: List<BannerBean>) {
        if (datas.isNotEmpty()) {
            val banner_urls = arrayListOf<String>()
            for (banner in datas) {
                banner_urls.add(banner.imagePath)
            }
            header_view.banner_homepage.update(banner_urls)
            banner_datas.clear()
            banner_datas.addAll(datas)
        }

    }

    override fun getBannerFailed(message: String?) {
        if (!message.isNullOrBlank()) showToast(message!!)
    }

    override fun refreshHomePageSuccceed(datas: List<ArticleContentBean>) {
        when {
            isRefresh -> isRefresh = false;
            else -> status_manager.onSuccess()
        }
        if (datas.isNotEmpty()) {
            homepage_adapter.clear()
            homepage_adapter.addAll(datas)
        }
    }

    override fun loadMoreHomePageSuccceed(datas: List<ArticleContentBean>) {
        if (datas.isNotEmpty()) {
            homepage_adapter.addAll(datas)
        }
    }

    override fun getHomepageFailed(message: String?) {
        when {
            isRefresh -> isRefresh = false
            else -> status_manager.onSuccess()
        }
        if (!message.isNullOrBlank()) showToast(message!!)
    }

    private lateinit var homepage_adapter: HomePageAdapter
    private var banner_datas = ArrayList<BannerBean>()
    private lateinit var status_manager: StatusViewManager
    private lateinit var header_view: View
    private var page = 0
    private var isRefresh = false

    override fun setListener() {
        header_view.banner_homepage.setOnBannerListener {

        }
        txt_searchbar.setOnClickListener {

        }
        recycler_homepage.addRefreshAction {
            isRefresh = true
            page = 0
            mPresenter?.getHomePageDatas(page)
        }
        recycler_homepage.setLoadMoreAction {
            page++
            mPresenter?.getHomePageDatas(page)
        }
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        status_manager = StatusViewManager.createView(context, recycler_homepage)
        homepage_adapter = HomePageAdapter(context, ArrayList())
        recycler_homepage.setLayoutManager(LinearLayoutManager(context))
        recycler_homepage.setSwipeRefreshColorsFromRes(R.color.tab_selected_color)
        recycler_homepage.setItemSpace(0, 4, 0, 6)
        recycler_homepage.setAdapter(homepage_adapter)
        header_view = createView(R.layout.layout_homepage_header)
        header_view.banner_homepage.setImageLoader(GlideImageLoader())
        homepage_adapter.header = header_view
        status_manager.onLoad()
    }

    override fun getLayoutId(): Int = R.layout.fragment_homepage

}