package com.therippleeffect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import java.util.*

class QuestWriteActivity : AppCompatActivity() {
    var initiator: EditText?= null
    var puddleName: EditText?= null
    var credibility: EditText?= null
    var type: EditText?= null
    var details: EditText?= null
    var locationCountry: EditText?= null
    var locationCity: EditText?= null
    var dateCreated: EditText?= null
    var requiredRipples: EditText?= null
    var puddleQuest: EditText?= null
    val imageName = UUID.randomUUID().toString() + ".jpg"


    override fun onCreate(savedInstanceState: Bundle?) {
        title = getString(R.string.create_new_ripple)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_write)
    }
}
