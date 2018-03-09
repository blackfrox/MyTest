package com.example.mygame.mvp.news

import android.content.Context
import com.example.mygame.api.ApiService
import com.example.mygame.api.RetrofitClient
import com.example.mygame.bean.LatestNews
import rx.Observable

/**
 * Created by Administrator on 2017/8/15.
 */
class NewsModel(private val context: Context): NewsContract.Model {


    override fun getBeforeNews(date: String): Observable<LatestNews>? {
     val retrofit=RetrofitClient.getInstance(context)
     return retrofit.getApi()?.getBeforeNews(date)
    }

    override fun getLatestNews(): Observable<LatestNews>? {
        val retrofit=RetrofitClient.getInstance(context)
        return retrofit.create(ApiService::class.java)?.getLatestNews()
    }
}