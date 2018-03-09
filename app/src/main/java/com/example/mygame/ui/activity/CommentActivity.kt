package com.example.mygame.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.mygame.R
import com.example.mygame.bean.Comment
import com.example.mygame.mvp.comment.CommentContract
import com.example.mygame.mvp.comment.CommentPresenter
import com.example.mygame.ui.CommentAdapter1
import kotlinx.android.synthetic.main.activity_comment.*

/**
 * Created by Administrator on 2017/8/16.
 */
class CommentActivity: BaseActivity(),CommentContract.View {


     lateinit var mPresenter: CommentPresenter

    private val TAG="CommentActivity"
    override fun getLayoutRes(): Int {
        return R.layout.activity_comment
    }
    override fun initView() {
        var id=intent.getIntExtra(ContentActiviyty.NEWSID,0)
        Log.d(TAG,"$id")

        mPresenter= CommentPresenter(this,this)
        mPresenter.getComment(id)

    }
    override fun setData(list: List<Comment.CommentsBean>) {
       var mAdapter= CommentAdapter1(list)

        Log.d("btan",list.toString())
        cmment_recyclerview.layoutManager=LinearLayoutManager(this)
        cmment_recyclerview.adapter=mAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
//        mPresenter.unSubscribe()
    }
}