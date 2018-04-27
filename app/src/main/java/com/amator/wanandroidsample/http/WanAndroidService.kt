package com.amator.wanandroidsample.http

import com.amator.wanandroidsample.bean.*
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by AmatorLee on 2018/4/26.
 */
interface WanAndroidService {

    //首页
    @GET("article/list/{page}/json")
    fun getHomePage(@Path("page") page: Int): Observable<BaseBean<ArticleTmpBean>>

    //广告
    @GET("banner/json")
    fun getBanner(): Observable<BaseBean<List<BannerBean>>>

    //常用网站
    @GET("friend/json")
    fun getFriendWebSite(): Observable<BaseBean<FriendWebSiteBean>>

    //搜索热词
    @GET("hotkey/json")
    fun getHotKey(): Observable<BaseBean<HotKeyBean>>

    //体系
    @GET("tree/json")
    fun getTree(): Observable<BaseBean<TreeBean>>

    //体系下article
    @GET("article/list/{page}/json")
    fun getTreeChild(@Path("page") page: Int, @Query("cid") cid: Int): Observable<BaseBean<ArticleTmpBean>>

    //导航
    @GET("navi/json")
    fun getNavi(): Observable<BaseBean<NaviBean>>


    //项目
    @GET("project/tree/json")
    fun getProjectTree(): Observable<BaseBean<List<ProjectBean>>>

    //项目下articles
    @GET("project/list/{page}/json")
    fun getProjectTreeArticles(@Path("page") page: Int, @Query("cid") cid: Int): Observable<BaseBean<ArticleTmpBean>>

    //登录
    @POST("user/login")
    @FormUrlEncoded
    fun userLogin(@Field("username") username: String, @Field("password") password: String): Observable<BaseBean<UserBean>>

    //注册
    @POST("user/register")
    @FormUrlEncoded
    fun userRegister(@Field("username") username: String
                     , @Field("password") password: String,
                     @Field("repassword") repassword: String): Observable<BaseBean<UserBean>>

    //收藏列表
    @GET("lg/collect/list/{page}/json")
    fun getCollectArticle(@Path("page") page: Int): Observable<BaseBean<ArticleTmpBean>>

    //收藏站内文章
    @POST("lg/collect/{page}/json")
    fun collectWebsiteArticle(@Path("page") page: Int): Observable<CollectBean>

    //收藏站外文章
    @POST("lg/collect/add/json")
    @FormUrlEncoded
    fun collectOutWebsiteArticle(@Field("title") title: String,
                                 @Field("author") author: String,
                                 @Field("link") link: String): Observable<BaseBean<ArticleContentBean>>

    //首页取消收藏
    @POST("lg/uncollect_originId/{id}/json")
    fun unCollectArticle(@Path("id") id: Int): Observable<CollectBean>

    //收藏列表取消收藏,originid无则为-1
    @POST("lg/uncollect/{id}/json")
    fun unCollectArticleOnCollection(@Path("id") id: Int, @Field("originId") originId: Int): Observable<BaseBean<ArticleTmpBean>>


    /**
     * 收藏网站待完善，貌似URL有点儿问题
     */
    //关键字查询
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    fun search(@Path("page") page: Int, @Field("k") key: String): Observable<BaseBean<ArticleTmpBean>>
}