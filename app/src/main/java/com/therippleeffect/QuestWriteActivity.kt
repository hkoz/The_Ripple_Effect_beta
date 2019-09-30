package com.therippleeffect

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream
import java.util.*


@Suppress("DEPRECATION")
class QuestWriteActivity : AppCompatActivity() {
    var puddleName: EditText? = null
    var initiator: EditText? = null
    var quest: EditText? =null
    var countryLocation: EditText? = null
    var cityLocation: EditText? = null
    var requiredRipples: EditText? = null
    var createdRipples: EditText? = null
    var type: EditText? = null
    var status: EditText?=null
    var credibility: EditText? =null
    var reports: EditText?=null
    var details: EditText? = null
    var image1:ImageView?=null




    override fun onCreate(savedInstanceState: Bundle?) {
        title = getString(R.string.create_new_puddle)
        image1 =findViewById(R.id.write_image_view)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_write)
    }

    fun formNewPuddleButtonPressed (view :View) {
        puddleName=findViewById(R.id.edit_puddle_name_text)
        initiator=findViewById(R.id.edit_initiator_name_text)
        quest=findViewById(R.id.edit_quest_text)
        countryLocation=findViewById(R.id.edit_location_country_text)
        cityLocation=findViewById(R.id.edit_location_city_text)
        requiredRipples=findViewById(R.id.edit_required_ripple_text)
        createdRipples =findViewById(R.id.edit_ripples_created_text)
        type=findViewById(R.id.edit_type_text)
        status=findViewById(R.id.edit_Status_text)
        credibility=findViewById(R.id.edit_credibility_text)
        reports=findViewById(R.id.edit_reports_text)
        details=findViewById(R.id.edit_details_text)

        val map: Map<String, String> = mapOf(

            getString(R.string.puddleNameKey) to puddleName?.text.toString(),
            getString(R.string.initiatorKey) to initiator?.text.toString(),
            getString(R.string.questKey) to quest?.text.toString(),
            getString(R.string.countryKey) to countryLocation?.text.toString(),
            getString(R.string.cityKey) to cityLocation?.text.toString(),
            getString(R.string.reqRipplesKey) to requiredRipples?.text.toString(),
            getString(R.string.createdRipplesKey) to createdRipples?.text.toString(),
            getString(R.string.typeKey) to type?.text.toString(),
            getString(R.string.statusKey) to status?.text.toString(),
            getString(R.string.credibilityKey) to credibility?.text.toString(),
            getString(R.string.reportsKey) to reports?.text.toString(),
            getString(R.string.detailsKey) to details?.text.toString(),
            getString(R.string.dateKey) to Puddle.getCurrentDate()
        )


        if (puddleName?.text.toString() != null && puddleName?.text.toString().isNotEmpty()){
            if (quest?.text.toString() != null && quest?.text.toString().isNotEmpty()){
                if (countryLocation?.text.toString() != null && countryLocation?.text.toString().isNotEmpty()){
                    if (cityLocation?.text.toString() != null && cityLocation?.text.toString().isNotEmpty()){
                        if (requiredRipples?.text.toString() != null && requiredRipples?.text.toString().isNotEmpty()){
                            if (type?.text.toString() != null && type?.text.toString().isNotEmpty()){
                                if (status?.text.toString() != null && status?.text.toString().isNotEmpty()){
                                    if (details?.text.toString() != null && details?.text.toString().isNotEmpty()){
                                        val database = FirebaseDatabase.getInstance()
                                        val myRef = database.getReference("Puddles")
                                        myRef.push().setValue(map)
                                        Log.i("Map", map.toString())
                                        startActivity(Intent(this,MyActivity::class.java))
                                    }
                                    else {Toast.makeText(this,getString(R.string.no_details),Toast.LENGTH_SHORT).show()}
                                }
                                else {Toast.makeText(this,getString(R.string.no_status),Toast.LENGTH_SHORT).show()}
                            }
                            else {Toast.makeText(this,getString(R.string.no_type),Toast.LENGTH_SHORT).show()}
                        }
                        else {Toast.makeText(this,getString(R.string.no_ripples),Toast.LENGTH_SHORT).show()}
                    }
                    else {Toast.makeText(this,getString(R.string.no_city),Toast.LENGTH_SHORT).show()}
                }
                else {Toast.makeText(this,getString(R.string.no_country),Toast.LENGTH_SHORT).show()}
            }
            else {Toast.makeText(this,getString(R.string.no_quest),Toast.LENGTH_SHORT).show()}
        }
        else {Toast.makeText(this,getString(R.string.no_name),Toast.LENGTH_SHORT).show()}

    }


    fun futureFeature(view : View){
        Toast.makeText(this,getString(R.string.no_function),Toast.LENGTH_SHORT).show()
    }




}
