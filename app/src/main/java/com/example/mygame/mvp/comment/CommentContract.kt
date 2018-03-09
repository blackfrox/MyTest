package com.example.mygame.mvp.comment

import com.example.mygame.bean.Comment
import rx.Observable

/**
 * Created by Administrator on 2017/8/16.
 */
interface CommentContract {

    interface View{
        fun setData(list: List<Comment.CommentsBean>)
    }

    interface Presenter{
        fun getComment(id: Int)
    }

    interface Model{
        fun getComment(id: Int): Observable<Comment>?
    }
}