package com.therippleeffect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth

class MyActivity : AppCompatActivity() {
    val mauth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        title = getString(R.string.my_activity)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        val vp = findViewById<ViewPager>(R.id.viewPager)
        val puddlesFragmentPagerAdapter = PuddlesFragmentPagerAdapter(this@MyActivity, supportFragmentManager)
        vp.adapter = puddlesFragmentPagerAdapter
        val tab = findViewById<TabLayout>(R.id.tableLayout)
        tab.setupWithViewPager(vp)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_new_puddle -> startActivity(Intent(this@MyActivity,QuestWriteActivity::class.java))
            R.id.create_new_ripple -> startActivity(Intent(this@MyActivity,PuddleSearchActivity::class.java))
            R.id.profile ->startActivity(Intent(this@MyActivity,ProfileActivity::class.java))
            R.id.logout -> {mauth.signOut()
                startActivity(Intent(this@MyActivity,LogInActivity::class.java))}
        }
        return super.onOptionsItemSelected(item)
    }
}
