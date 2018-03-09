package com.example.mygame.mvp.news

import android.content.Context
import com.example.mygame.bean.LatestNews
import com.example.mygame.util.applyScheduler

/**
 * Created by Administrator on 2017/8/15.
 */
class NewsPresenter(  context: Context,  mView: NewsContract.View)
    : NewsContract.Presenter {

    private var mView: NewsContract.View?=null
    private var context: Context?=null
    init {
        this.context=context
        this.mView=mView
    }
    val mModel by lazy { NewsModel(context) }
    override fun getLatestNews() {


        var observable=mModel.getLatestNews()
         observable?.applyScheduler()?.subscribe {
           bean: LatestNews ->
//           Log.d("bean",bean.toString())
           mView?.setData(bean.stories)
       }
    }

    override fun getBeforeNews(date: String) {
        mModel.getBeforeNews(date)?.applyScheduler()?.subscribe {
            bean: LatestNews ->
           mView?.setData(bean.stories)
        }
    }


}