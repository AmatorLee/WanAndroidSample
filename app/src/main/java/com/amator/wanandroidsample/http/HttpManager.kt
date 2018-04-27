package com.amator.wanandroidsample.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by AmatorLee on 2018/4/26.
 * cookie部分有借鉴，感谢
 */
object HttpManager {

    private val TAG = "HttpManager"

    private val WANANDROID_URL = "http://www.wanandroid.com/"

    private val SAVE_USER_LOGIN_KEY = "user/login"
    private val SAVE_USER_REGISTER_KEY = "user/register"
    private val SET_COOKIE_KEY = "set-cookie"
    private val COOKIE_NAME = "Cookie"

    private val mRetrofit by lazy {
        createRetrofit()
    }

    val sInstance by lazy {
        mRetrofit.create(WanAndroidService::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(WANANDROID_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initClient())
                .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(15L, TimeUnit.SECONDS)
                .writeTimeout(15L, TimeUnit.SECONDS)
                .addInterceptor {
                    val request = it.request()
                    val response = it.proceed(request)
                    val requestUrl = request.url().toString()
                    val domain = request.url().host()
                    if ((requestUrl.contains(SAVE_USER_LOGIN_KEY) || requestUrl.contains(
                                    SAVE_USER_REGISTER_KEY
                            ))
                            && !response.headers(SET_COOKIE_KEY).isEmpty()) {
                        val cookies = response.headers(SET_COOKIE_KEY)
                        val cookie = encodeCookie(cookies)
                        saveCookie(requestUrl, domain, cookie)
                    }
                    response
                }
                // set request cookie
                .addInterceptor {
                    val request = it.request()
                    val builder = request.newBuilder()
                    val domain = request.url().host()
                    // get domain cookie
                    if (domain.isNotEmpty()) {
                        val spDomain: String by Preference(domain, "")
                        val cookie: String = if (spDomain.isNotEmpty()) spDomain else ""
                        if (cookie.isNotEmpty()) {
                            builder.addHeader(COOKIE_NAME, cookie)
                        }
                    }
                    it.proceed(builder.build())
                }
                .build()
    }

    /**
     * save cookie string
     */
    fun encodeCookie(cookies: List<String>): String {
        val sb = StringBuilder()
        val set = HashSet<String>()
        cookies
                .map { cookie ->
                    cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                }
                .forEach {
                    it.filterNot { set.contains(it) }.forEach { set.add(it) }
                }

        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }

        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }

        return sb.toString()
    }

    /**
     * save cookie to SharePreferences
     */
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    private fun saveCookie(url: String?, domain: String?, cookies: String) {
        url ?: return
        var spUrl: String by Preference(url, cookies)
        @Suppress("UNUSED_VALUE")
        spUrl = cookies
        domain ?: return
        var spDomain: String by Preference(domain, cookies)
        @Suppress("UNUSED_VALUE")
        spDomain = cookies
    }

}