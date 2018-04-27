package com.amator.wanandroidsample.bean

/**
 * Created by AmatorLee on 2018/4/26.
 */

data class TreeBean(
    val children: List<TreeChildBean>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val visible: Int
)