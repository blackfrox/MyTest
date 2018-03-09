package com.example.mygame.api

import android.content.Context
import com.example.mygame.util.NetworkUtil
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Administrator on 2017/8/15.
 */
class CacheInterceptor(private val context: Context): Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        var request=chain?.request()
        if (NetworkUtil.isNetConneted(context)){
            val response=chain?.proceed(request)
            //read from cache for 60s
            val maxAge=60
            val cacheControl=request?.cacheControl().toString()
            return response?.newBuilder()?.removeHeader("Pragma")?.removeHeader("Cache-Control")?.
                    header("Cache-Control","public,max-age"+maxAge)?.build()
        }else{
            request=request?.newBuilder()?.cacheControl(CacheControl.FORCE_CACHE)?.build()
            val response=chain?.proceed(request)
            //set cache times is 3 day
            val maxStale=60*60*24*3
            return response?.newBuilder()?.removeHeader("Pragma")?.removeHeader("Cache-Control")?.
                    header("Cache-Control","public,only-if-cached,max-stale="+maxStale)?.build()
        }
    }
}