package com.therippleeffect

import android.Manifest
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
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import java.io.ByteArrayOutputStream
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



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
    var puddleNameKey = "PNK"
    var initiatorKey = "INK"
    var questKey = "QDK"
    var countryKey = "CLK"
    var cityKey = "CLK"
    var ripplesRKeys = "RRK"
    var ripplesCKey ="RCK"
    var typeKey = "TDK"
    var statusKey ="SDK"
    var credibilityKey ="CBK"
    var reportsKey = "RSK"
    var detailsKey = "DDK"
    var valuesList: MutableList<EditText?> = mutableListOf()
    var keysList: MutableList<String> = mutableListOf()
    val imageName = UUID.randomUUID().toString() + ".webp"
    var database = FirebaseDatabase.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        title = getString(R.string.create_new_puddle)
        image1 =findViewById(R.id.write_image_view)
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

        valuesList.clear()
        valuesList.add(puddleName!!)
        valuesList.add(initiator!!)
        valuesList.add(quest!!)
        valuesList.add(countryLocation!!)
        valuesList.add(cityLocation!!)
        valuesList.add(requiredRipples!!)
        valuesList.add(createdRipples!!)
        valuesList.add(type!!)
        valuesList.add(status!!)
        valuesList.add(credibility!!)
        valuesList.add(reports!!)
        valuesList.add(details!!)
        keysList.add(puddleNameKey)
        keysList.add(initiatorKey)
        keysList.add(questKey)
        keysList.add(countryKey)
        keysList.add(cityKey)
        keysList.add(ripplesRKeys)
        keysList.add(ripplesCKey)
        keysList.add(typeKey)
        keysList.add(statusKey)
        keysList.add(credibilityKey)
        keysList.add(reportsKey)
        keysList.add(detailsKey)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_write)
    }

    fun formNewPuddleButtonPressed (view :View){
        val createdPuddle = database.getReference("Puddles")
        createdPuddle.push().setValue(createStringArrayfromThePage(keysList,valuesList))
        }

    fun createStringArrayfromThePage (keysList:MutableList<String>, valuesList: MutableList<EditText?>) :HashMap<String,String> {

        val resultMap :HashMap <String,String> = HashMap()
        for (i in 0 .. valuesList.size) {
            var value =""
            if (valuesList[i] == null){}
            else  value = valuesList[i]?.text.toString()
            resultMap.put(keysList[i], value )
        }
        return resultMap
    }

    fun getPhoto() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val selectedImage = data!!.data

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImage)
                image1?.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getPhoto()
            }
        }
    }

    fun addImagesClicked(view: View) {

        image1?.isDrawingCacheEnabled = true
        image1?.buildDrawingCache()
        val bitmap = image1?.drawingCache
        val baos = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.WEBP, 100, baos)
        val data = baos.toByteArray()



        val uploadTask = FirebaseStorage.getInstance().reference.child("images").child(imageName).putBytes(data)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
            Toast.makeText(this,"UploadFailed", Toast.LENGTH_SHORT).show()
        }

    }
}
