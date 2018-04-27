package com.amator.wanandroidsample.adapter

import android.content.Context
import android.view.ViewGroup
import com.amator.wanandroidsample.adapter.viewholder.HomePageViewHolder
import com.amator.wanandroidsample.bean.ArticleContentBean
import com.amator.wanandroidsample.refreshRecyclerView.adapter.BaseViewHolder
import com.amator.wanandroidsample.refreshRecyclerView.adapter.RecyclerAdapter

/**
 * Created by AmatorLee on 2018/4/27.
 */
class HomePageAdapter(context: Context,datas:ArrayList<ArticleContentBean>) : RecyclerAdapter<ArticleContentBean>(context,datas) {


    override fun onCreateBaseViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ArticleContentBean> {
        return HomePageViewHolder(parent)
    }

}