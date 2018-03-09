package com.example.mygame.api

import android.content.Context
import android.util.Log
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/8/15.
 */
class RetrofitClient (private val context: Context){
    var httpCacheDir: File?=null
    var cache: Cache?=null
    var client: OkHttpClient?=null
    var retrofit: Retrofit?=null
    val DEFAULT_TIMEOUT: Long=20
    val baseUrl="http://news-at.zhihu.com/"
    init {
        //缓存地址
        if(httpCacheDir==null){
            httpCacheDir=File(context.cacheDir,"app_cache")
        }
        try {
            if (cache==null){
                cache=Cache(httpCacheDir,1024*1024*10L)
            }
        }catch (e: Exception){
            Log.e("OkHttp","Could not create http cache",e)
        }
        //okHttp创建
        client=OkHttpClient.Builder()
//                .cache(cache)
//                .addInterceptor(CacheInterceptor(context))
//                .addNetworkInterceptor(CacheInterceptor(context))
//                .connectTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
//                .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .build()

        //retrofit创建
        retrofit=Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    companion object {
        @Volatile
        var instance: RetrofitClient?=null

        fun getInstance(context: Context): RetrofitClient{
            if (instance==null){
                synchronized(RetrofitClient::class){
                    if (instance==null){
                        instance= RetrofitClient(context)
                    }
                }
            }
            return instance!!
        }
    }

    fun <T> create(service: Class<T>): T?{
        if (service==null){
            throw RuntimeException("Api service is null!")
        }
        return retrofit?.create(service)
    }

    fun getApi(): ApiService? {

        return instance!!.create(ApiService::class.java)
    }
}