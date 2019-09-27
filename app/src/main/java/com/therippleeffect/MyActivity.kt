package com.therippleeffect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        val vp = findViewById<ViewPager>(R.id.viewPager)
        val puddlesFragmentPagerAdapter = PuddlesFragmentPagerAdapter(this@MyActivity, supportFragmentManager)
        vp.adapter = puddlesFragmentPagerAdapter
        val tab = findViewById<TabLayout>(R.id.tableLayout)
        tab.setupWithViewPager(vp)


    }
}
