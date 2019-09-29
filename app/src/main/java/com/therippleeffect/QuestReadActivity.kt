package com.therippleeffect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class QuestReadActivity : AppCompatActivity() {

    var puddleName: TextView? = null
    var dateCreated: TextView? = null
    var initiator: TextView? = null
    var quest: TextView? =null
    var countryLocation: TextView? = null
    var cityLocation: TextView? = null
    var requiredRipples: TextView? = null
    var createdRipples: TextView? = null
    var type: TextView? = null
    var status:TextView?=null
    var credibility:TextView? =null
    var reports:TextView?=null
    var details: TextView? = null
    var receivedPuddle: Puddle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        title = getString(R.string.create_new_ripple)
        puddleName=findViewById(R.id.puddle_name_text)
        initiator=findViewById(R.id.initiator_name_text)
        dateCreated=findViewById(R.id.date_text)
        quest=findViewById(R.id.quest_text)
        countryLocation=findViewById(R.id.location_country_text)
        cityLocation=findViewById(R.id.location_city_text)
        requiredRipples=findViewById(R.id.required_ripple_text)
        createdRipples =findViewById(R.id.ripples_created_text)
        type=findViewById(R.id.type_text)
        status=findViewById(R.id.Status_text)
        credibility=findViewById(R.id.credibility_text)
        reports=findViewById(R.id.reports_text)
        details=findViewById(R.id.details_text)

        puddleName?.text = receivedPuddle?.puddleName
        initiator?.text = receivedPuddle?.puddleInitiator
        dateCreated?.text = receivedPuddle?.puddleDateCreated
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
