package com.example.mygame.bean

import android.service.quicksettings.Tile

/**
 * Created by Administrator on 2017/8/15.
 */
data class LatestNews (val date: String,val stories: List<StoriesBean>,val top_stroies: List<TopStoriesBean>){

    data class StoriesBean(val title: String,val ga_prefix: String,val multipic: Boolean,
                           val type: Int,val id: Int,val images: List<String>)

    data class TopStoriesBean(val image: String,val type: Int,val id: Int,
                              val ga_prefix: String,val tile: String)
}