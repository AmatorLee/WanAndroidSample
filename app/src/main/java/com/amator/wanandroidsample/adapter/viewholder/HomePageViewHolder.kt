package com.amator.wanandroidsample.adapter.viewholder

import android.view.ViewGroup
import android.widget.TextView
import com.amator.wanandroidsample.R
import com.amator.wanandroidsample.bean.ArticleContentBean
import com.amator.wanandroidsample.refreshRecyclerView.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.layout_homepage_item.view.*

/**
 * Created by AmatorLee on 2018/4/27.
 */
class HomePageViewHolder(val parent: ViewGroup) : BaseViewHolder<ArticleContentBean>(parent, R.layout.layout_homepage_item) {

    private var name: TextView? = null
    private var title: TextView? = null
    private var time: TextView? = null
    private var tag: TextView? = null

    override fun onInitializeView() {
        name = itemView.txt_artical_author_value
        title = itemView.txt_artical_name
        time = itemView.txt_artical_time
        tag = itemView.txt_artical_tag_value
    }

    override fun onItemViewClick(data: ArticleContentBean?) {

    }

    override fun setData(data: ArticleContentBean?) {
        name?.text = data?.author
        title?.text = data?.title
        tag?.text = data?.chapterName
        time?.text = data?.niceDate
    }

}