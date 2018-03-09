package com.example.mygame.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Administrator on 2017/8/15.
 */
abstract class BaseFragment: Fragment() {

    var parentView: View?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parentView=inflater.inflate(getLayoutRes(),container,false)
        initView()
        return parentView
    }

    abstract fun getLayoutRes(): Int

    abstract fun initView()
}
