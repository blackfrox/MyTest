package com.example.mygame.ui.activity

import android.content.Intent
import android.opengl.Visibility
import android.view.View
import android.webkit.WebChromeClient
import com.bumptech.glide.Glide
import com.example.mygame.R
import com.example.mygame.bean.News
import com.example.mygame.mvp.content.ContentContract
import com.example.mygame.mvp.content.ContentPresenter
import com.example.mygame.ui.NewsAdapter
import com.example.mygame.ui.fragment.NewsFragment
import com.example.mygame.util.HtmlFormat
import com.example.mygame.util.statuToolbar
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.content_news.*

/**
 * Created by Administrator on 2017/8/16.
 */
class ContentActiviyty: BaseActivity(),ContentContract.View {
    override fun getLayoutRes(): Int {
        return R.layout.activity_content
    }

    lateinit var mPresenter: ContentPresenter

    override fun initView() {

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        statuToolbar()
          mPresenter= ContentPresenter(this,this)
        var id=intent.getIntExtra(NewsAdapter.ID,0)

        mPresenter.getNews(id)

        fab.setOnClickListener {
            var intent=Intent(this,CommentActivity::class.java)
            intent.putExtra(NEWSID,id)
            startActivity(intent)
        }
        fab.visibility=View.INVISIBLE
        //通过此方法来判断是否显示fab，如果id=0就不显示
        mPresenter.getComment(id)
    }

    override fun setData(result: News) {
        Glide.with(this).load(result.image).into(news_image)
        with(result){
           toolbar_layout.title=title
            news_content.loadDataWithBaseURL(null,HtmlFormat.getNewContent(body),"text/html","utf-8",null)
            news_content.settings.javaScriptEnabled=true
            var settings=news_content.settings
            news_content.webChromeClient= WebChromeClient()
        }

    }

    override fun fabVisible() {
//       fab.visibility=View.VISIBLE
    }

    companion object {
        val NEWSID="newsId"
    }
}