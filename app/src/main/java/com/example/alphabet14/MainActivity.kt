package com.example.alphabet14

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

//import sun.net.ext.ExtendedSocketOptions.options


class MainActivity : AppCompatActivity() {
    private lateinit var buttonA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  ActivityCompat.requestPermissions(MainActivity.this,
        //    new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE},
          //  1);

        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)



        val imageView: ImageView = findViewById(R.id.imageView)
        var bit: Bitmap = BitmapFactory.decodeFile("/sdcard/DCIM/yuno.jpg")
        val imageInSD = "/sdcard/DCIM/yuno.jpg"

        try {

            bit= BitmapFactory.decodeFile(imageInSD)
        } catch (e: OutOfMemoryError) {
            try {
                val options = BitmapFactory.Options()
                options.inSampleSize = 2
                bit= BitmapFactory.decodeFile(imageInSD, options)
            } catch (e: Exception) {
                Log.e(",","",e)
            }
        }
        imageView.setImageBitmap(bit)

      //  val bMap:Bitmap = BitmapFactory.decodeFile("/sdcard/DCIM/yuno.jpg")
      //  val scabit: Bitmap = Bitmap.createScaledBitmap(bMap,  50 ,50, true)
      //  imageView.setImageBitmap(scabit)



        switchActivity()
    }

    fun switchActivity(){

        buttonA =  findViewById(R.id.buttonA)

        buttonA.setOnClickListener{
            val intent = Intent(this,LetterActivity::class.java)
          //  intent.putExtra("SHOW_WELCOME", true)
            startActivity(intent)
          //  finish()
        }
    }

    // Function to check and request permission.
    private fun checkPermission(permission: String, requestCode: Int) {
       // if (ContextCompat.checkSelfPermission(this@MainActivity, permission) == PackageManager.PERMISSION_DENIED) {
            // Requesting the permission
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
     //   } else {
           // Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT).show()
        }






}