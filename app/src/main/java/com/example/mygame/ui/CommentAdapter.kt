package com.example.mygame.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mygame.R
import com.example.mygame.bean.Comment
import kotlinx.android.synthetic.main.comment_item.view.*

/**
 * Created by Administrator on 2017/8/16.
 */
class CommentAdapter(list: List<Comment.CommentsBean>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    var mlist: List<Comment.CommentsBean>?=null

    init {
        this.mlist=list
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindTo(mlist!![position]!!)
    }

    override fun getItemCount(): Int {
      return mlist?.size ?:0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          return ViewHolder(LayoutInflater.from(parent.context).
                  inflate(R.layout.comment_item,parent,false))
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindTo(bean: Comment.CommentsBean){
            with(bean){
                itemView.comment_name.text=author
                itemView.comment_content.text=content
                itemView.like_number.text=likes.toString()
                Glide.with(itemView.context).load(avatar)
                        .into(itemView.comment_image)
            }
        }
    }
}