package com.example.mygame.mvp.content

import com.example.mygame.bean.News
import com.example.mygame.bean.StoryExtra
import rx.Observable


/**
 * Created by Administrator on 2017/8/16.
 */
interface ContentContract {
    interface View {
        fun setData(result: News)
        fun fabVisible()
    }

    interface Presenter{
        fun getNews(id : Int)
        fun getComment(id: Int)
    }

    interface Model{
        fun getNews(id: Int): Observable<News>
        fun getCommentNum(id: Int): Observable<StoryExtra>
    }
}