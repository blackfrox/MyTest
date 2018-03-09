package com.example.mygame.ui

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mygame.R
import com.example.mygame.bean.LatestNews
import com.example.mygame.ui.activity.ContentActiviyty
import kotlinx.android.synthetic.main.zhihudaily_news_item.view.*

/**
 * Created by Administrator on 2017/8/15.
 */
class NewsAdapter(  mList: List<LatestNews.StoriesBean>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var mList: List<LatestNews.StoriesBean>?=null

    init {
        this.mList=mList
    }
    override fun getItemCount(): Int =mList?.size ?:0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder {
       return NewsViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.zhihudaily_news_item,parent,false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder?, position: Int) {
        holder?.bindToNews(mList!![position])
    }

    class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindToNews(bean: LatestNews.StoriesBean){
            with(bean){
                itemView.latest_news_title.text=title
                Glide.with(itemView.context)
                        .load(images[0])
                        .into(itemView.latest_news_image)

               itemView.setOnClickListener {
                   var intent=Intent(itemView.context,ContentActiviyty::class.java)
                   intent.putExtra(ID,id)
                   itemView.context.startActivity(intent)
               }
            }
        }
    }

    companion object {
        val ID="id"
    }
}

