package com.example.mygame.mvp.news

import com.example.mygame.bean.LatestNews
import rx.Observable

/**
 * Created by Administrator on 2017/8/15.
 */
interface NewsContract {

    interface View{
        fun setData(storiesList: List<LatestNews.StoriesBean>)
    }

    interface Presenter{
        fun getBeforeNews(date: String)
        fun getLatestNews()
    }

    interface Model{
        fun getBeforeNews(date: String) : Observable<LatestNews>?
        fun getLatestNews(): Observable<LatestNews>?
    }
}