package com.example.mygame.mvp.comment

import android.content.Context
import com.example.mygame.bean.Comment
import com.example.mygame.mvp.BasePresenter

import com.example.mygame.util.applyScheduler
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by Administrator on 2017/8/16.
 */
class CommentPresenter(private val context: Context,
                           private val mView: CommentContract.View)
    : CommentContract.Presenter,BasePresenter(){

    val mModel by lazy { CommentModel(context) }

    override fun getComment(id: Int) {
        mModel.getComment(id)?.
                subscribeOn(AndroidSchedulers.mainThread())?.
                subscribe { (comments) ->
            mView.setData(comments)
        }
    }

}