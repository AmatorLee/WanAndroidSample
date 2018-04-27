package com.amator.wanandroidsample.util

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import com.amator.wanandroidsample.WanAndroidApp
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by AmatorLee on 2018/4/26.
 */

fun isNetConnected(): Boolean {
    val context = WanAndroidApp.applicationComponent.appContext
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
    if (networkInfo != null && networkInfo.isAvailable) {
        return networkInfo.isConnected
    }
    return false
}

fun <T> Observable<T>.applySchedules(): Observable<T> {
    return subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}


fun createView(layoutId: Int): View {
    return LayoutInflater.from(getContext()).inflate(layoutId, null)
}

fun getContext(): Context {
    return WanAndroidApp.applicationComponent.appContext;
}

fun getColorByRes(colorId:Int):Int{
    return getContext().resources.getColor(colorId)
}