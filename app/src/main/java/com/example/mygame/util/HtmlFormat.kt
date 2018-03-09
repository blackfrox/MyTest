package com.example.mygame.util

import org.jsoup.Jsoup

/**
 * Created by Administrator on 2017/8/16.
 */
object HtmlFormat{
    //使图片自适应屏幕
    fun getNewContent(hemlText: String): String{
        var doc=Jsoup.parse(hemlText)
        var elements=doc.getElementsByTag("img")
        elements
                .filterNot { it.attr("class").equals("avatar") }
                .forEach { it.attr("width","100%").attr("height","auto") }
        return doc.toString()
    }
}