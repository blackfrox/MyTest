package com.example.mygame.mvp.content

import android.content.Context
import com.example.mygame.bean.News
import com.example.mygame.bean.StoryExtra
import com.example.mygame.util.applyScheduler

/**
 * Created by Administrator on 2017/8/16.
 */
class ContentPresenter(private val context: Context,private val mView:ContentContract.View)
    :ContentContract.Presenter{

    val mModel by lazy { ContentModel(context) }

    override fun getNews(id: Int) {
        mModel.getNews(id)?.applyScheduler().subscribe {
            bean : News->
            mView.setData(bean)
        }
    }

    override fun getComment(id: Int) {
       mModel.getCommentNum(id)?.applyScheduler().subscribe {
           bean: StoryExtra ->
           if (bean.long_comments!=0){
               mView.fabVisible()
           }
    }
    }
}