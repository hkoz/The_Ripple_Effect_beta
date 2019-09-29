package com.therippleeffect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class QuestReadActivity : AppCompatActivity() {

    var puddleName: TextView? = null
    var initiator: TextView? = null
    var datecreated: TextView? = null
    var requiredRipples: TextView? = null
    var createdRipples: TextView? = null
    var type: TextView? = null
    var countryLocation: TextView? = null
    var cityLocation: TextView? = null
    var details: TextView? = null
    var quest: TextView? =null
    var status:TextView?=null
    var credibility:TextView? =null
    var receivedPuddle: Puddle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        title = getString(R.string.create_new_puddle)
        receivedPuddle = intent.getSerializableExtra("Puddle") as Puddle
        puddleName=findViewById(R.id.puddle_name_text)
        initiator=findViewById(R.id.initiator_name_text)
        datecreated=findViewById(R.id.date_text)
        requiredRipples=findViewById(R.id.no_required_ripple_text)
        type=findViewById(R.id.type_text)
        countryLocation=findViewById(R.id.read_location_country_label)
        cityLocation=findViewById(R.id.read_location_city_label)
        quest=findViewById(R.id.quest_text)
        details=findViewById(R.id.details_text)
        credibility=findViewById(R.id.credibility_text)
        status=findViewById(R.id.Status_text)
        createdRipples = findViewById(R.id.no_ripples_created_text)

        puddleName?.text = receivedPuddle?.puddleName
        initiator?.text = receivedPuddle?.puddleInitiator
        datecreated?.text = receivedPuddle?.puddleDateCreated
        requiredRipples?.text = receivedPuddle?.puddleRequiredRipples.toString()
        type?.text = receivedPuddle?.puddleType
        countryLocation?.text = receivedPuddle?.puddleCountryLocation
        cityLocation?.text = receivedPuddle?.puddleCityLocation
        quest?.text = receivedPuddle?.puddleQuest
        details?.text = receivedPuddle?.puddleQuest
        credibility?.text = receivedPuddle?.puddleCredibilityBoostsNumber.toString()
        status?.text= receivedPuddle?.puddleStatus



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_read)
    }
}
