package com.example.mygame


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.RecyclerView
import com.example.mygame.Test.TestFragment
import com.example.mygame.ui.fragment.NewsFragment
import com.example.mygame.util.statuToolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mFragments=ArrayList<android.support.v4.app.Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statuToolbar()
        initToolbar()
        initView()
    }

     fun initView(){
         mFragments.add(NewsFragment.instance())
         mFragments.add(TestFragment())
         viewPager.adapter= object : FragmentPagerAdapter(supportFragmentManager){
             override fun getItem(position: Int): android.support.v4.app.Fragment {
                 return mFragments[position]
             }

             override fun getCount(): Int {
               return mFragments.size
             }
         }
     }

    fun initToolbar(){
         setSupportActionBar(toolbar)
         toolbar.title="知乎"

     }
}
