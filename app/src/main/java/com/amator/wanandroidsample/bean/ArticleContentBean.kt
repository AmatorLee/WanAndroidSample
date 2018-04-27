package com.amator.wanandroidsample.bean

/**
 * Created by AmatorLee on 2018/4/26.
 */
data class ArticleContentBean(
        /**
         * {
        "apkLink": "",
        "author": "美团点评技术团队",
        "chapterId": 93,
        "chapterName": "基础知识",
        "collect": false,
        "courseId": 13,
        "desc": "",
        "envelopePic": "",
        "fresh": true,
        "id": 2875,
        "link": "https://tech.meituan.com/hardware-accelerate.html",
        "niceDate": "28分钟前",
        "origin": "",
        "projectLink": "",
        "publishTime": 1524750988000,
        "superChapterId": 126,
        "superChapterName": "自定义控件",
        "tags": [],
        "title": "Android硬件加速原理与实现简介",
        "type": 0,
        "visible": 1,
        "zan": 0
        }
         */
        val apkLink: String,
        val author: String,
        val chapterId: Int,
        val chapterName: String,
        val collect: Boolean,
        val courseId: Int,
        val desc: String,
        val envelopePic: String,
        val fresh: Boolean,
        val id: Int,
        val link: String,
        val niceDate: String,
        val origin: String,
        val projectLink: String,
        val publishTime: Long,
        val superChapterId: Int,
        val superChapterName: String,
        val tags: List<Any>,
        val title: String,
        val type: Int,
        val visible: Int,
        val zan: Int
)
