package com.amator.wanandroidsample.mvp.base

/**
 * Created by AmatorLee on 2018/4/26.
 */
interface BasePresenter {

    fun attachView(baseView: BaseView)

    fun detachView()

}