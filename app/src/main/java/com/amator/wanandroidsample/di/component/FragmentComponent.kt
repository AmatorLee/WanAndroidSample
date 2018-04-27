package com.amator.wanandroidsample.di.component

import android.app.Activity
import android.content.Context
import com.amator.wanandroidsample.di.module.FragmentModule
import com.amator.wanandroidsample.di.scope.ContextLife
import com.amator.wanandroidsample.di.scope.PerFragment
import com.amator.wanandroidsample.ui.fragment.HomePageFragment
import com.amator.wanandroidsample.ui.fragment.MineFragment
import com.amator.wanandroidsample.ui.fragment.NavigationFragment
import com.amator.wanandroidsample.ui.fragment.TixiFragment
import dagger.Component

/**
 * Created by AmatorLee on 2018/4/26.
 */
@PerFragment
@Component(modules = [FragmentModule::class], dependencies = [ApplicationComponent::class])
interface FragmentComponent {

    @ContextLife("App")
    val appContext: Context

    @ContextLife("Activity")
    val activityContext: Context

    val activity: Activity


    fun inject(fragment: HomePageFragment)

    fun inject(fragment: TixiFragment)

    fun inject(fragment: NavigationFragment)

    fun inject(fragment: MineFragment)
}