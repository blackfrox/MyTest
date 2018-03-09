package com.example.mygame.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import com.example.mygame.R
import com.example.mygame.bean.LatestNews
import com.example.mygame.mvp.news.NewsContract
import com.example.mygame.mvp.news.NewsPresenter
import com.example.mygame.ui.NewsAdapter
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_zhihudaily_news.*
import java.util.*

/**
 * Created by Administrator on 2017/8/15.
 */
class NewsFragment: BaseFragment(), NewsContract.View, DatePickerDialog.OnDateSetListener {


    var mPresenter: NewsPresenter?=null
     var mAdapter: NewsAdapter?=null

    override fun getLayoutRes(): Int {
        return R.layout.fragment_zhihudaily_news
    }

    override fun initView() {
        mPresenter= NewsPresenter(context, this)
        mPresenter?.getLatestNews()


        activity.floatingButton.setOnClickListener {
                val now= Calendar.getInstance()
             val dpd=DatePickerDialog.newInstance(
                     this,
                     now.get(Calendar.YEAR),
                     now.get(Calendar.MONTH),
                     now.get(Calendar.DAY_OF_MONTH))
            dpd.show(activity.fragmentManager,"Datepickerdialog")
        }
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
           val date: String=String.format("%d%02d%02d",year,monthOfYear,dayOfMonth)
        mPresenter?.getBeforeNews(date)
    }

    override fun setData(storiesList: List<LatestNews.StoriesBean>) {
        mAdapter= NewsAdapter(storiesList)
        latest_news_recyclerView.layoutManager=LinearLayoutManager(context)
        latest_news_recyclerView.adapter=mAdapter
    }



  companion object {
      fun instance(): NewsFragment{
          var instance=NewsFragment()
          return instance
      }
  }
}