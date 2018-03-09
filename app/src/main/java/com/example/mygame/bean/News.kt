package com.example.mygame.bean

/**
 * Created by Administrator on 2017/8/15.
 */
data class News (val body: String,val image_source: String,val title: String,val image: String,
                 val share_url: String,val ga_prefix: String,val type: Int,val id: Int,
                 val images: List<String>,val css: List<String>)