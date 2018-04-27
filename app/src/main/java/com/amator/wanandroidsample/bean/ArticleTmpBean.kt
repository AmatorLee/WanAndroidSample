package com.amator.wanandroidsample.bean

/**
 * Created by AmatorLee on 2018/4/26.
 */

data class ArticleTmpBean(
        val curPage: Int,
        val datas: List<ArticleContentBean>,
        val offset: Int,
        val over: Boolean,
        val pageCount: Int,
        val size: Int,
        val total: Int
)
