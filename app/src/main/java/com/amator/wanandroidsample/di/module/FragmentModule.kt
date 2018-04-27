package com.amator.wanandroidsample.di.module

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import com.amator.wanandroidsample.di.scope.ContextLife
import dagger.Module
import dagger.Provides

/**
 * Created by AmatorLee on 2018/4/26.
 */
@Module
class FragmentModule(val fragment: Fragment) {


    @ContextLife("Activity")
    @Provides
    internal fun provideActivityContext(): Context {
        return fragment.context
    }

    @Provides
    internal fun provideActivity(): Activity {
        return fragment.activity
    }

    @Provides
    internal fun provideFragment(): Fragment {
        return fragment
    }

}