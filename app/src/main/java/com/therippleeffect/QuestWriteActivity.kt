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

    val imageName = UUID.randomUUID().toString() + ".webp"


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

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Puddles")
        myRef.push().setValue(map)
        Log.i("Map", map.toString())

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
