package com.amator.wanandroidsample.di.module

import android.app.Activity
import android.content.Context
import com.amator.wanandroidsample.di.scope.ContextLife
import dagger.Module
import dagger.Provides

/**
 * Created by AmatorLee on 2018/4/26.
 */
@Module
class ActivityModule(val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @ContextLife("Activity")
    internal fun provideActivityContext(): Context {
        return activity
    }

}