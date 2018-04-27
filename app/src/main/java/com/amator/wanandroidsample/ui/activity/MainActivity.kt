package com.amator.wanandroidsample.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.amator.wanandroidsample.R
import com.amator.wanandroidsample.adapter.FragmentAdapter
import com.amator.wanandroidsample.base.BaseActivity
import com.amator.wanandroidsample.factory.FragmentFactory
import com.amator.wanandroidsample.mvp.base.BasePresenter
import com.amator.wanandroidsample.mvp.presenter.impl.MainActivityPresenterImpl
import com.amator.wanandroidsample.mvp.view.MainView
import com.amator.wanandroidsample.util.getColorByRes
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityPresenterImpl>(), MainView {
    override fun setCurrentItem(pos: Int) {
        bbl.currentItem = pos
    }


    @Inject
    lateinit var mainActivityPresenterImpl: MainActivityPresenterImpl
    private val fragments = arrayOfNulls<Fragment>(4)

    override fun inPresenter(): BasePresenter {
        activityComponent.inject(this)
        return mainActivityPresenterImpl
    }

    override fun setListener() {
//      bbl.setOnItemSelectedListener { _, p1, p2 ->
//          Log.d("Bottom","i: " + p1 + ",i1: " + p2);
////          setCurrentItem(p1)
//      }
    }

    override fun initView(savedInstanceState: Bundle?) {
        systemutil.setStatusBarTintColor(getColorByRes(R.color.white))
//        if (savedInstanceState == null) {
//
//        } else {
//            fragments[0] = supportFragmentManager.findFragmentByTag("homePage")
//            fragments[1] = supportFragmentManager.findFragmentByTag("tixi")
//            fragments[2] = supportFragmentManager.findFragmentByTag("navigation")
//            fragments[3] = supportFragmentManager.findFragmentByTag("mine")
//        }
        fragments[0] = FragmentFactory.create(FragmentFactory.HOME_PAGE)
        fragments[1] = FragmentFactory.create(FragmentFactory.TIXI)
        fragments[2] = FragmentFactory.create(FragmentFactory.NAVIGATION)
        fragments[3] = FragmentFactory.create(FragmentFactory.MINE)
        vp_content.adapter = FragmentAdapter(fragments, supportFragmentManager)
        vp_content.offscreenPageLimit = 4
        bbl.setViewPager(vp_content)
        bbl.setSmoothScroll(true)
//        bbl.currentItem = 0
    }

    override fun getLayoutId(): Int = R.layout.activity_main


}
