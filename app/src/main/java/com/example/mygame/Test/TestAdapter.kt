package com.example.mygame.Test

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mygame.R

/**
 * Created by Administrator on 2017/8/16.
 */
class TestAdapter(mList: String): RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    var mList:String?=null

    init {
        this.mList=mList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_test,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.title?.text=mList
    }


    override fun getItemCount(): Int {
        return 1
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView?=null
        init {
            title=itemView.findViewById(R.id.item_title)
        }
    }
}