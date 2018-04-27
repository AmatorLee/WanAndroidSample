package com.amator.wanandroidsample.mvp.presenter.impl

import com.amator.wanandroidsample.mvp.presenter.WelcomePresenter
import com.amator.wanandroidsample.mvp.view.WelcomeView
import javax.inject.Inject


/**
 * Created by AmatorLee on 2018/4/27.
 */
class WelcomePresenterImpl
@Inject constructor():BasePresenterImpl<WelcomeView>(),WelcomePresenter{


    override fun getBanner() {

    }

}