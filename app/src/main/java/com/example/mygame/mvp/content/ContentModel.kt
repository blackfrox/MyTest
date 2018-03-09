package com.example.mygame.mvp.content

import android.content.Context
import com.example.mygame.api.ApiService
import com.example.mygame.api.RetrofitClient
import com.example.mygame.bean.News
import com.example.mygame.bean.StoryExtra
import rx.Observable

/**
 * Created by Administrator on 2017/8/16.
 */
class ContentModel(private val context: Context): ContentContract.Model {
    override fun getNews(id: Int): Observable<News> {
        val retrofit=RetrofitClient.getInstance(context)
        return retrofit.create(ApiService::class.java)!!.getNews(id)
    }

    override fun getCommentNum(id: Int): Observable<StoryExtra> {
        val retrofit=RetrofitClient.getInstance(context)
        return retrofit.getApi()!!.getStroyExtra(id)
    }
}