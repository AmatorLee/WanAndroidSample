package com.amator.wanandroidsample.di.module

import android.content.Context
import com.amator.wanandroidsample.WanAndroidApp
import dagger.Module
import dagger.Provides

/**
 * Created by AmatorLee on 2018/4/26.
 */
@Module
class ApplicationModule(val wanAndroidApp: WanAndroidApp) {


    @Provides
    internal fun provideApp(): WanAndroidApp {
        return wanAndroidApp
    }

    @Provides
    internal fun provideAppContext(): Context {
        return wanAndroidApp.applicationContext
    }


}