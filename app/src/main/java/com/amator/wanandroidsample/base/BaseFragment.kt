package com.amator.wanandroidsample.base

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.amator.wanandroidsample.WanAndroidApp
import com.amator.wanandroidsample.di.component.ApplicationComponent
import com.amator.wanandroidsample.di.component.FragmentComponent
import com.amator.wanandroidsample.mvp.base.BasePresenter
import com.amator.wanandroidsample.mvp.base.BaseView
import javax.inject.Inject

/**
 * Created by AmatorLee on 2018/4/26.
 */
abstract class BaseFragment<T : BasePresenter> : Fragment(), BaseView {

    protected lateinit var fragmentComponent: FragmentComponent


    @Nullable
    @Inject
    @JvmField
    var mPresenter: T? = null
    protected var mView: View? = null

    /**
     * 是否可见状态
     */
    private var isFragmentVisible: Boolean = false

    /**
     * 标志位，View已经初始化完成。
     */
    private var isPrepared: Boolean = false

    /**
     * 是否第一次加载
     */
    private var isFirstLoad: Boolean = true


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (mView == null) {
            mView = inflater!!.inflate(getLayoutId(), container, false)
        }
        isFirstLoad = true
        return mView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (view != null) {
            injector(WanAndroidApp.applicationComponent)
            mPresenter?.attachView(this)
            initView(mView!!, savedInstanceState)
            setListener()
            isPrepared = true
            onLazyLoad()
        }
    }

    /**
     * 如果是与ViewPager一起使用，调用的是setUserVisibleHint
     *
     * @param isVisibleToUser 是否显示出来了
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (userVisibleHint) {
            isFragmentVisible = true
            onVisible()
        } else {
            isFragmentVisible = false
            onInvisible()
        }
    }

    protected fun onVisible() {
        onLazyLoad()
    }

    protected fun onInvisible() {


    }

    private fun onLazyLoad() {
        if (!isPrepared || !isFragmentVisible || !isFirstLoad) {
            return
        }
        isFirstLoad = false
        initData()
    }

    abstract fun initData()

    abstract fun setListener()

    abstract fun initView(view: View, savedInstanceState: Bundle?)

    abstract fun injector(applicationComponent: ApplicationComponent)

    abstract fun getLayoutId(): Int

    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.let {
            it.detachView()
            mPresenter = null
        }
    }

}