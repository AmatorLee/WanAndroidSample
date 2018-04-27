package com.amator.wanandroidsample

import android.app.Application
import com.amator.wanandroidsample.di.component.ApplicationComponent
import com.amator.wanandroidsample.di.component.DaggerApplicationComponent
import com.amator.wanandroidsample.di.module.ApplicationModule
import com.amator.wanandroidsample.http.Preference
import kotlin.properties.Delegates

/**
 * Created by AmatorLee on 2018/4/26.
 */
class WanAndroidApp : Application() {


    companion object {
        var applicationComponent: ApplicationComponent by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        initJector()
        Preference.setContext(this)
    }

    private fun initJector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}