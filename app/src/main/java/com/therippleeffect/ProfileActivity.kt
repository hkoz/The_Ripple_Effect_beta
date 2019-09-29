package com.therippleeffect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        title = getString(R.string.my_profile)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}
