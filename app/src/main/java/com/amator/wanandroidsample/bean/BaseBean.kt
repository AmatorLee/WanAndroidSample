package com.amator.wanandroidsample.bean

/**
 * Created by AmatorLee on 2018/4/26.
 */
class BaseBean<T> {

    var errorCode = 0
    var errorMsg = ""
    var data: T? = null

    fun isSucceed(): Boolean {
        return errorCode == 0
    }

}