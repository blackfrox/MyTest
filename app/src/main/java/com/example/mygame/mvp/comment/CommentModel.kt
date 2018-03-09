package com.example.mygame.mvp.comment

import android.content.Context
import com.example.mygame.api.RetrofitClient
import com.example.mygame.bean.Comment
import rx.Observable


/**
 * Created by Administrator on 2017/8/16.
 */
class CommentModel (private val context: Context): CommentContract.Model{
    override fun getComment(id: Int): Observable<Comment>? {
         var retrofit=RetrofitClient.getInstance(context)
        return retrofit.getApi()?.getComments(id)
    }
}