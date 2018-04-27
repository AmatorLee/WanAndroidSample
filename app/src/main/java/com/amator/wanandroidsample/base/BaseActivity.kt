package com.amator.wanandroidsample.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import com.amator.wanandroidsample.WanAndroidApp
import com.amator.wanandroidsample.di.component.ActivityComponent
import com.amator.wanandroidsample.di.component.DaggerActivityComponent
import com.amator.wanandroidsample.di.module.ActivityModule
import com.amator.wanandroidsample.mvp.base.BasePresenter
import com.amator.wanandroidsample.mvp.base.BaseView
import com.readystatesoftware.systembartint.SystemBarTintManager


/**
 * Created by AmatorLee on 2018/4/26.
 */
abstract class BaseActivity<T : BasePresenter> : AppCompatActivity(), BaseView {

    protected lateinit var activityComponent: ActivityComponent
    private var basePresenterImpl: BasePresenter? = null
    protected lateinit var systemutil: SystemBarTintManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initJecttor()
        initSystem()
        basePresenterImpl = inPresenter()
        basePresenterImpl?.attachView(this)
        initView(savedInstanceState)
        setListener()
    }

    private fun initSystem() {
        systemutil = SystemBarTintManager(this)
        systemutil.setNavigationBarTintEnabled(true)
        setTranslucentStatus()
    }

    private fun setTranslucentStatus() {
        val win = window
        val winParams = win.attributes
        val bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        winParams.flags = winParams.flags or bits
        win.attributes = winParams
    }

    abstract fun inPresenter(): BasePresenter

    private fun initJecttor() {
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(WanAndroidApp.applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
    }

    abstract fun setListener()

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun getLayoutId(): Int

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        basePresenterImpl?.let {
            it.detachView()
            basePresenterImpl = null
        }
    }

}