package com.amator.wanandroidsample.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by AmatorLee on 2018/4/26.
 */
class FragmentAdapter(val array: Array<Fragment?>, val supportManager: FragmentManager) : FragmentPagerAdapter(supportManager) {
    override fun getItem(position: Int): Fragment? {
        return array[position]
    }

    override fun getCount(): Int {
        return array.size
    }

}