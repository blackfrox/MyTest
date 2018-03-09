package com.example.mygame

import android.app.Application
import android.content.pm.ApplicationInfo



/**
 * Created by Administrator on 2017/8/15.
 */
class App: Application() {

    init {
        instance=this
    }

    override fun onCreate() {
        super.onCreate()


    }
    companion object {
         lateinit var instance: App
    }
}