package com.example.mygame.bean

/**
 * Created by Administrator on 2017/8/15.
 */
data class Comment(val comments: List<CommentsBean>){

    data class CommentsBean(val author: String,val content: String,val avatar: String,
                            val time: Int,val id: Int,val likes: Int,val reply_to: ReplyToBean){

        data class ReplyToBean(val content: String,val staus: Int,val id: Int,
                               val author: String)
    }
}