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
import java.io.FileNotFoundException
import java.lang.NullPointerException




class MainActivity : AppCompatActivity() {
    private lateinit var buttonA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission() // Makes sure to get permission

        switchActivity()
    }

    fun switchActivity(){

        buttonA =  findViewById(R.id.button01)

        buttonA.setOnClickListener{
            var butoonText:String = buttonA.text.toString()
            val intent = Intent(this,LetterActivity::class.java)
            intent.putExtra("Button_number",butoonText)
            startActivity(intent)
          //  finish()
        }
    }

    // Function to check and request permission.
    private fun checkPermission() {
        // if (ContextCompat.checkSelfPermission(this@MainActivity, permission) == PackageManager.PERMISSION_DENIED) {
        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_DENIED
        ) {
            // Requesting the permission
            // ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        } else {
            Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT)
                .show()
        }

        // ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        //if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)

    }


}