package com.example.mygame.util

import android.app.Activity
import android.os.Build
import android.view.WindowManager
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Administrator on 2017/8/15.
 */
fun <T>Observable<T>.applyScheduler(): Observable<T> {
    return subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun Activity.statuToolbar(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        var params=window.attributes
        params.flags=(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }
}
