package com.amator.wanandroidsample.mvp.presenter.impl

import com.amator.wanandroidsample.mvp.base.BasePresenter
import com.amator.wanandroidsample.mvp.base.BaseView

/**
 * Created by AmatorLee on 2018/4/26.
 */
abstract class BasePresenterImpl<T> : BasePresenter {


    override fun attachView(baseView: BaseView) {
        this.mView = baseView as T
    }

    protected var mView: T? = null


    override fun detachView() {
        this.mView?.let { mView = null }
    }
}