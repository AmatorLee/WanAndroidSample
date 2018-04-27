package com.amator.wanandroidsample.factory

import android.support.v4.app.Fragment
import android.util.SparseArray
import com.amator.wanandroidsample.ui.fragment.HomePageFragment
import com.amator.wanandroidsample.ui.fragment.MineFragment
import com.amator.wanandroidsample.ui.fragment.NavigationFragment
import com.amator.wanandroidsample.ui.fragment.TixiFragment

/**
 * Created by AmatorLee on 2018/4/26.
 */
class FragmentFactory {
    companion object {
        val HOME_PAGE = 0
        val TIXI = 1
        val NAVIGATION = 2
        val MINE = 3
        private val fragmentArray: SparseArray<Fragment> = SparseArray(4)

        fun create(index: Int): Fragment {
            var fragment = fragmentArray.get(index)
            if (fragment == null) {
                fragment = when (index) {
                    HOME_PAGE -> HomePageFragment()
                    TIXI -> TixiFragment()
                    NAVIGATION -> NavigationFragment()
                    MINE -> MineFragment()
                    else -> null
                }
                fragmentArray.put(index, fragment)
            }
            return fragment
        }
    }

}