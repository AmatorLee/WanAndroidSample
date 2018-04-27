package com.amator.wanandroidsample.di.component

import android.app.Activity
import android.content.Context
import com.amator.wanandroidsample.di.module.ActivityModule
import com.amator.wanandroidsample.di.scope.ContextLife
import com.amator.wanandroidsample.di.scope.PerActivity
import com.amator.wanandroidsample.ui.activity.MainActivity
import com.amator.wanandroidsample.ui.activity.WelcomeActivity
import dagger.Component

/**
 * Created by AmatorLee on 2018/4/26.
 */
@PerActivity
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    @ContextLife("App")
    val applicationContext: Context

    @ContextLife("Activity")
    val activityContext: Context

    val activity: Activity

    fun inject(activity: MainActivity)

    fun inject(activity: WelcomeActivity)
}