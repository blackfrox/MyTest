package com.example.mygame.api

import com.example.mygame.bean.Comment
import com.example.mygame.bean.LatestNews
import com.example.mygame.bean.News
import com.example.mygame.bean.StoryExtra
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by Administrator on 2017/8/15.
 */
interface ApiService {
    @GET("api/4/news/latest")
    fun getLatestNews(): Observable<LatestNews>

    @GET("api/4/news/before/{date}")
    fun getBeforeNews(@Path("date") dateString: String): Observable<LatestNews>

    @GET("api/4/news/{id}")
    fun getNews(@Path("id") id: Int): Observable<News>

    @GET("api/4/story/{id}/long-comments")
    fun getComments(@Path("id") id: Int): Observable<Comment>

    @GET("api/4/story-extra/{id}")
    fun getStroyExtra(@Path("id") id: Int): Observable<StoryExtra>
}