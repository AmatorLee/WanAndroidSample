package com.amator.wanandroidsample.ui.activity

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import com.amator.wanandroidsample.R
import com.amator.wanandroidsample.base.BaseActivity
import com.amator.wanandroidsample.mvp.base.BasePresenter
import com.amator.wanandroidsample.mvp.presenter.impl.WelcomePresenterImpl
import com.amator.wanandroidsample.mvp.view.WelcomeView
import com.amator.wanandroidsample.util.getColorByRes
import kotlinx.android.synthetic.main.activity_welcome.*
import yanzhikai.textpath.PathAnimatorListener
import yanzhikai.textpath.painter.ArrowPainter
import javax.inject.Inject

/**
 * Created by AmatorLee on 2018/4/27.
 */
class WelcomeActivity : BaseActivity<WelcomePresenterImpl>(), WelcomeView {

    @Inject
    lateinit var welcomePresenterImpl: WelcomePresenterImpl

    override fun inPresenter(): BasePresenter {
        activityComponent.inject(this)
        return welcomePresenterImpl
    }

    override fun setListener() {
        sync_textview.setAnimatorListener(object : PathAnimatorListener() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                finish()
            }
        })
    }



    override fun onResume() {
        super.onResume()
        sync_textview.startAnimation(0f, 1f)
    }

    override fun initView(savedInstanceState: Bundle?) {
        sync_textview.setDuration(2500)
        sync_textview.setPathPainter(ArrowPainter ())
        systemutil.setStatusBarTintColor(getColorByRes(R.color.white))
    }

    override fun getLayoutId(): Int = R.layout.activity_welcome

    override fun getBannerSucceed() {
    }

    override fun getBannerFailed() {
    }

}