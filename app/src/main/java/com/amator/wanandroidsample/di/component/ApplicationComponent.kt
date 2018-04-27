package com.amator.wanandroidsample.di.component

import android.content.Context
import com.amator.wanandroidsample.WanAndroidApp
import com.amator.wanandroidsample.di.module.ApplicationModule
import com.amator.wanandroidsample.di.scope.ContextLife
import com.amator.wanandroidsample.di.scope.PerApp
import dagger.Component

/**
 * Created by AmatorLee on 2018/4/26.
 */
@PerApp
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    val application: WanAndroidApp

    @ContextLife("App")
    val appContext:Context

}